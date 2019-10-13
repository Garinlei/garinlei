package com.yinhai.leijl.chapter4.defaulfFunction4_6;

public interface Child1 extends Parent1 {
    @Override
    default void welcome() {
        System.out.println("Child1..haha");
    }
}
