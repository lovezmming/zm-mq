package com.shev.zm.mq.common.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopic
{
    public static final String KAFKA_MY_TOPIC = "MY_KAFKA_TOPIC";

    public static final String KAFKA_MY_TOPIC_BAK = "MY_KAFKA_TOPIC_BAK";

    @Bean(name = "MY_KAFKA_TOPIC")
    public NewTopic myTopic()
    {
        return new NewTopic(KAFKA_MY_TOPIC, 5, (short)2);
    }
}
