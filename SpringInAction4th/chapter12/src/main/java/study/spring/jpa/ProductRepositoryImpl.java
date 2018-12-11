package com.estgames.cabal1.shop.product.repository;

import com.estgames.cabal1.shop.common.TagType;
import com.estgames.cabal1.shop.common.ViewType;
import com.estgames.cabal1.shop.menu.model.MainMenu;
import com.estgames.cabal1.shop.menu.model.MenuProduct;
import com.estgames.cabal1.shop.menu.model.QMainMenu;
import com.estgames.cabal1.shop.menu.model.QMenuProduct;
import com.estgames.cabal1.shop.menu.model.QSubMenu;
import com.estgames.cabal1.shop.menu.model.SubMenu;
import com.estgames.cabal1.shop.product.model.Product;
import com.estgames.cabal1.shop.product.model.QProduct;
import com.estgames.cabal1.shop.product.search.ProductSearch;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.JPQLQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * @author asdf
 */
public class ProductRepositoryImpl extends QueryDslRepositorySupport implements ProductCustomRepository {

    @PersistenceContext
    EntityManager em;

    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> getProductList(long mainIdx, long subIdx, Pageable pageable, ProductSearch productSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> r = cq.from(Product.class);

        List<Predicate> cq_criteria = new ArrayList<Predicate>();
        List<Predicate> sq_criteria = new ArrayList<Predicate>();

        Subquery<Long> sq = cq.subquery(Long.class);
        Root<MenuProduct> pm = sq.from(MenuProduct.class);
        Join<MenuProduct, SubMenu> pm_sm = pm.join("subMenu", JoinType.INNER);
        Join<MenuProduct, Product> pm_p = pm.join("product", JoinType.INNER);
        Join<SubMenu, MainMenu> sm_mm = pm_sm.join("mainMenu", JoinType.INNER);

        if (mainIdx != 0) {
            sq_criteria.add(cb.equal(sm_mm.get("menuMainIdx"), mainIdx));
        }
        if (subIdx != 0) {
            sq_criteria.add(cb.equal(pm_sm.get("subMenuIdx"), subIdx));
        }
        sq.select(pm_p.get("productId")).where(cb.and(sq_criteria.toArray(new Predicate[sq_criteria.size()])));

        cq_criteria.add(cb.equal(r.get("viewType"), ViewType.OPEN));
        cq_criteria.add(cb.in(r.get("productId")).value(sq));

        if (productSearch.getSearchText() != null && !productSearch.getSearchText().equals("")) {
            cq_criteria.add(cb.like(r.get("productName"), "%" + productSearch.getSearchText() + "%"));
        }

        cq.select(r)
                .where(cb.and(cq_criteria.toArray(new Predicate[cq_criteria.size()])));

        return em.createQuery(cq)
                .setFirstResult(pageable.getPageNumber())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
    }

    @Override
    public SearchResults<Product> getProductPage(long mainIdx, long subIdx, Pageable pageable, ProductSearch productSearch) {
        QProduct product = QProduct.product;
        QMenuProduct menuProduct = QMenuProduct.menuProduct;
        QSubMenu subMenu = QSubMenu.subMenu;
        QMainMenu mainMenu = QMainMenu.mainMenu;

        JPQLQuery query = from(product);
        JPASubQuery subquery = new JPASubQuery();

        subquery.from(menuProduct)
                .leftJoin(menuProduct.subMenu, subMenu)
                .leftJoin(menuProduct.product, product)
                .leftJoin(subMenu.mainMenu, mainMenu);

        List<Predicate> sq_criteria = new ArrayList<Predicate>();
        if (mainIdx != 0) {
            subquery.where(mainMenu.menuMainIdx.eq(mainIdx));
        }
        if (subIdx != 0) {
            subquery.where(subMenu.subMenuIdx.eq(subIdx));
        }

        if (productSearch.getSearchText() != null && !productSearch.getSearchText().equals("")) {
            query.where(product.productName.contains(productSearch.getSearchText()));
        }

        return query.where(product.viewType.eq(ViewType.OPEN)
                .and(product.productId.in(subquery.list(product.productId)))
                .and(product.startDate.isNull().or(product.startDate.before(new Date())))
                .and(product.finishDate.isNull().or(product.finishDate.after(new Date())))
        )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .listResults(product);
    }

    @Override
    public List<Product> getProductTypeNoneIgnore() {
        QProduct product = QProduct.product;

        JPQLQuery query = from(product);

        return query.where(product.viewType.eq(ViewType.OPEN)
                .and(product.tagType.ne(TagType.NONE))
                .and(product.startDate.isNull().or(product.startDate.before(new Date())))
                .and(product.finishDate.isNull().or(product.finishDate.after(new Date())))
        )
                .list(product);
    }

}
