package com.sjy.shining.task;

import org.springframework.stereotype.Component;

@Component
public class testTask {

    public void test(String params){
        System.out.println("testtesttesttesttesttest"+params);
        System.out.println(System.currentTimeMillis());

    }

    public void test2(){
        System.out.println("test222222222222222222222");
        System.out.println(System.currentTimeMillis());

    }
}
