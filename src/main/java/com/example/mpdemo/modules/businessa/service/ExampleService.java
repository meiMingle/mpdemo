package com.example.mpdemo.modules.businessa.service;


import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ExampleService{

    public String doSomething(Function<String,String> func){
        return func.apply("Hello ");
    }
}




