/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estgames.cabal1.shop.product.repository;

import com.estgames.cabal1.shop.product.model.Product;
import com.estgames.cabal1.shop.product.search.ProductSearch;
import com.mysema.query.SearchResults;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * @author asdf
 */
public interface ProductCustomRepository {
    public List<Product> getProductList(long mainIdx, long subIdx, Pageable pageable, ProductSearch productSearch);

    public List<Product> getProductTypeNoneIgnore();

    public SearchResults<Product> getProductPage(long mainIdx, long subIdx, Pageable pageable, ProductSearch productSearch);

}
