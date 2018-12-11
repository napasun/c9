package com.estgames.cabal1.shop.coupon.repository;

import java.util.List;

import com.estgames.cabal1.shop.coupon.model.Coupon;
import com.mysema.query.SearchResults;
import org.springframework.data.domain.Pageable;

public interface CouponCustomRepository {
    public List<Coupon> getList(int userNum, int first, int onePageCount);

    public Long getCount(int userNum);

    public List<Coupon> findByUserNumAndMasterIdAndUseDateTimeTodayAndStatusUSED(int userNum, Long masterId);

    public List<Coupon> findByDiscountCoupon(Long productId, int userNum);

    public SearchResults<Coupon> getUnUsedCouponList(int userNum, Pageable pageable);
}
