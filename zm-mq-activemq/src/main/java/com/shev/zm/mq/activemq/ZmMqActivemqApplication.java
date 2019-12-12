package com.shev.zm.mq.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class ZmMqActivemqApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ZmMqActivemqApplication.class, args);
    }

}
