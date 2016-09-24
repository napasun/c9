/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estgames.cabal1.shop.product.repository;

import com.estgames.cabal1.shop.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author asdf
 */
public interface ProductRepository extends JpaRepository<Product, Long>, ProductCustomRepository {
}
