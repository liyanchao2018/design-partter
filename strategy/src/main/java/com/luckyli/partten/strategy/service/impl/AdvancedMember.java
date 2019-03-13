package com.luckyli.partten.strategy.service.impl;

import com.luckyli.partten.strategy.service.Member;
import org.springframework.stereotype.Service;

/**
 * 高级会员,买书打八折
 */
@Service
public class AdvancedMember implements Member {
    @Override
    public double calPrice(double bookPrice) {
        System.out.println("对于高级会员的折扣为20%");
        return bookPrice * 0.8;
    }
}
