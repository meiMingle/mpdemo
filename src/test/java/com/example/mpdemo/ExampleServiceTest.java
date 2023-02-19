package com.example.mpdemo;

import com.example.mpdemo.modules.businessa.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExampleServiceTest{
    @Autowired
    ExampleService exampleService;

    @Test
    public void  testDoSomething(){
        System.out.println(exampleService.doSomething(a -> a + "World"));
    }

}
