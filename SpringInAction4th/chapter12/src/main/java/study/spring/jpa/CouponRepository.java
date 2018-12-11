package com.estgames.cabal1.shop.coupon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estgames.cabal1.shop.coupon.enumerable.CouponStatusType;
import com.estgames.cabal1.shop.coupon.model.Coupon;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long>, CouponCustomRepository {
    public Optional<Coupon> findOneByCouponId(Long couponId);

    public Optional<Coupon> findOneByCouponSerial(String couponSerial);

    public List<Coupon> findByUserNum(String userNum);

    public List<Coupon> findByUserNumAndStatusOrderByUseDateTimeDesc(int userNum, CouponStatusType couponStatusType);

    public List<Coupon> findByUserNumAndCouponMaster_masterIdAndStatusOrderByUseDateTimeDesc(int userNum, Long masterId, CouponStatusType status);
}
