package com.estgames.cabal1.shop.coupon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.estgames.cabal1.shop.coupon.enumerable.CouponStatusType;
import com.estgames.cabal1.shop.coupon.enumerable.CouponType;
import com.estgames.cabal1.shop.coupon.model.Coupon;
import com.estgames.cabal1.shop.coupon.model.QCoupon;
import com.estgames.cabal1.shop.coupon.model.QCouponMaster;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.JPQLQuery;
import java.util.Date;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class CouponRepositoryImpl extends QueryDslRepositorySupport implements CouponCustomRepository {

    @PersistenceContext
    EntityManager em;

    public CouponRepositoryImpl() {
        super(Coupon.class);
    }

    /**
     * 쿠폰 리스트
	 *
     */
    @Override
    public List<Coupon> getList(int userNum, int first, int onePageCount) {
        return em.createQuery("from " + Coupon.class.getName() + " where userNum=:userNum")
            .setParameter("userNum", userNum)
            .setFirstResult(first)
            .setMaxResults(onePageCount)
            .getResultList();
    }

    @Override
    public SearchResults<Coupon> getUnUsedCouponList(int userNum, Pageable pageable) {
        QCoupon coupon = QCoupon.coupon;
        
        JPQLQuery query = from(coupon);
        
        return query.where(coupon.userNum.eq(userNum)
            .and(coupon.status.eq(CouponStatusType.UNUSED))
            .and(coupon.startDateTime.isNull().or(coupon.startDateTime.before(new Date())))
            .and(coupon.expireDateTime.isNull().or(coupon.expireDateTime.after(new Date())))
            )
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .listResults(coupon);
    }
    
    /**
     * 쿠폰 갯수
	 *
     */
    @Override
    public Long getCount(int userNum) {
        QCoupon coupon = QCoupon.coupon;
        
        JPQLQuery query = from(coupon);       
        query.where(coupon.userNum.eq(userNum));
        
        return query.count();
    }

    /**
     * 당일 사용한 쿠폰이 있는 지 확인
	 *
     */
    @Override
    public List<Coupon> findByUserNumAndMasterIdAndUseDateTimeTodayAndStatusUSED(int userNum, Long masterId) {
        CouponStatusType couponStatusType = CouponStatusType.USED;

        return em.createQuery("from " + Coupon.class.getName() + " where userNum=:userNum and masterId=:masterId"
                + " and status=:status and Convert(varchar, getdate(), 101) = Convert(varchar, useDateTime, 101)")
                .setParameter("userNum", userNum)
                .setParameter("masterId", masterId)
                .setParameter("status", couponStatusType)
                .getResultList();
    }

    /**
     * 본인이 가진 사용하지 않은 할인 쿠폰 내역
     * @param userNum
     * @return
     */
    @Override
    public List<Coupon> findByDiscountCoupon(Long productId, int userNum) {
        QCoupon coupon = QCoupon.coupon;
        QCouponMaster couponMaster = QCouponMaster.couponMaster;
        
        JPQLQuery query = from(coupon)
            .leftJoin(coupon.couponMaster, couponMaster)
            .where(coupon.userNum.eq(userNum)
                .and(coupon.status.eq(CouponStatusType.UNUSED))
                .and(couponMaster.couponType.eq(CouponType.DISCOUNT))
                .and(couponMaster.isUse.eq(true))
                .and(coupon.startDateTime.before(new Date())
                    .or(coupon.startDateTime.isNull()))
                .and(coupon.expireDateTime.after(new Date())
                    .or(coupon.expireDateTime.isNull())));
        
        return query.list(coupon);
    }

}
