package com.yinhai.leijl.chapter4.defaulfFunction4_6;

public interface Parent1 {

    public default void welcome(){
        System.out.println("Parent1..haha");
    }
}
