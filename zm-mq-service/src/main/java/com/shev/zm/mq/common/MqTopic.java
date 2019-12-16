package com.shev.zm.mq.common;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

@Configuration
public class MqTopic
{
    public static final String ACTIVE_MQ_MY_TOPIC = "MY_ACTIVE_MQ_TOPIC";

    @Bean(name = "myTopic")
    public Topic myTopic()
    {
        return new ActiveMQTopic(ACTIVE_MQ_MY_TOPIC);
    }
}
