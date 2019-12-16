package com.shev.zm.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shev"})
public class ZmMqServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ZmMqServiceApplication.class, args);
    }

}
