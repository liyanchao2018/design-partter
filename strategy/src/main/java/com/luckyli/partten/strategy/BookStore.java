package com.luckyli.partten.strategy;

import com.luckyli.partten.strategy.service.Member;
import com.luckyli.partten.strategy.service.impl.AdvancedMember;

/**
 * 策略模式解决多个if else 条件
 * 假设我们是一家新开的书店，为了招揽顾客，我们推出会员服务，我们把店里的会员分为三种，分别是初级会员、中级会员和高级会员。
 * 针对不同级别的会员我们给予不同的优惠。初级会员买书我们不打折、中级会员买书我们打九折、高级会员买书我们打八折。
 *
 * 如果我们有一天想要把初级会员的折扣改成9.8折怎么办？有一天我要推出超级会员怎么办？有一天我要针对中级会员可打折的书的数量做限制怎么办？
 * 使用if\else设计出来的系统，所有的算法都写在了一起，只要有改动我就要修改整个类。
 * 我们都知道，只要是修改代码就有可能引入问题。为了避免这个问题，我们可以使用策略模式。。。
 */
public class BookStore {

    public static void main(String[] args) {
        /*//选择并创建需要使用的策略对象
        Member strategy = new AdvancedMember();
        //创建环境
        Cashier cashier = new Cashier(strategy);
        //计算价格
        double quote = cashier.quote(300);
        System.out.println("高级会员图书的最终价格为：" + quote);

        strategy = new IntermediateMember();
        cashier = new Cashier(strategy);
        quote = cashier.quote(300);
        System.out.println("中级会员图书的最终价格为：" + quote);*/

        /*******************如上 假如只知道userID，我们怎样去动态的调用高级会员、中级会员、初级会员的计算价格的方法呢？********************/
        //将所有策略的实现类放入缓存中（Map），根据key 得到需要的value（value保存需要的接口实现类），然后调用实现类的计算金额方法


    }
}
