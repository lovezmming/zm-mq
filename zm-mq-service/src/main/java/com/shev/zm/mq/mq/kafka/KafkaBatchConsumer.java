package com.shev.zm.mq.mq.kafka;

import com.shev.mq.kafka.handler.KafkaTopicConsumeHandler;
import com.shev.zm.mq.common.kafka.KafkaTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class KafkaBatchConsumer extends KafkaTopicConsumeHandler
{
    private static final Logger logger = LoggerFactory.getLogger(KafkaBatchConsumer.class);

    public KafkaBatchConsumer()
    {
        super(Arrays.asList(KafkaTopic.KAFKA_MY_TOPIC, KafkaTopic.KAFKA_MY_TOPIC_BAK), null, KafkaBatchConsumer.class);
    }

    @KafkaListener(topics = { KafkaTopic.KAFKA_MY_TOPIC, KafkaTopic.KAFKA_MY_TOPIC_BAK})
    public void dealMessage(String message)
    {
        logger.info("KafkaBatchConsumer主题消息(多主题)：" + message);
    }
}
