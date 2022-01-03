package com.zzang.core;

import com.zzang.core.discount.DiscountPolicy;
import com.zzang.core.discount.FixDiscountPolicy;
import com.zzang.core.discount.RateDiscountPolicy;
import com.zzang.core.member.MemberService;
import com.zzang.core.member.MemberServiceImpl;
import com.zzang.core.member.MemoryMemberRepository;
import com.zzang.core.order.OrderService;
import com.zzang.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
