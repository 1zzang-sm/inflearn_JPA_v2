package com.zzang.core;

import com.zzang.core.member.Grade;
import com.zzang.core.member.Member;
import com.zzang.core.member.MemberService;
import com.zzang.core.member.MemberServiceImpl;
import com.zzang.core.order.Order;
import com.zzang.core.order.OrderService;
import com.zzang.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order ==>>" + order);
        System.out.println("order.calculatePrice ==>>" + order.calculatePrice());

    }

}
