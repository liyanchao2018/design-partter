package com.luckyli.partten.strategy.service.impl;

import com.luckyli.partten.strategy.service.Member;
import org.springframework.stereotype.Service;

/**
 * 中级会员,买书打九折
 */
@Service
public class IntermediateMember implements Member {

    @Override
    public double calPrice(double bookPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return bookPrice * 0.9;
    }
}
