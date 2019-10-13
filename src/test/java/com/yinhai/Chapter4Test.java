package com.yinhai;

import com.yinhai.leijl.chapter4.defaulfFunction4_6.*;
import org.junit.Test;

public class Chapter4Test {


    @Test
    public void testDefault(){

        //调用了默认方法
        Parent1 parent1 = new Parent1Impl();
        parent1.welcome();

        //子类胜于父类 如果一个接口继承了另一个接口，都定义了一个默认方法，子类的默认方法胜出
        Child1 child1 = new Child1Impl();
        child1.welcome();

        //调用的是具体的方法，而不是默认方法
        OverrdingParent1 parent11 = new OverrdingParent1();
        parent11.welcome();


        //类胜于接口，如果在继承链中有方法体或抽象的方法申明，忽略接口中定义的
        Child1 child11 = new OverrdingChild1();
        child11.welcome();
    }
}
