package com.luckyli.partten.strategy;

import com.luckyli.partten.strategy.service.Member;
import com.luckyli.partten.strategy.service.impl.AdvancedMember;
import com.luckyli.partten.strategy.util.SpringBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyApplication {

    public static void main(String[] args) {

        SpringApplication.run(StrategyApplication.class, args);
        Member member = null;
        String clazz = AdvancedMember.class.getName();
        try {
            member = (Member) SpringBeanFactory.getBean(Class.forName(clazz));
            member.calPrice(300);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
