package com.luckyli.partten.strategy.service.impl;


import com.luckyli.partten.strategy.service.Member;
import org.springframework.stereotype.Service;

/**
 * 初级会员
 */
@Service
public class PrimaryMember implements Member {
    @Override
    public double calPrice(double bookPrice) {
        System.out.println("对于初级会员的没有折扣");
        return bookPrice;
    }
}
