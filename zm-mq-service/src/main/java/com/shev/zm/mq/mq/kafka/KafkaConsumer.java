package com.shev.zm.mq.mq.kafka;

import com.shev.mq.kafka.handler.KafkaTopicConsumeHandler;
import com.shev.zm.mq.common.kafka.KafkaTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer extends KafkaTopicConsumeHandler
{
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    public KafkaConsumer()
    {
        super(null, KafkaTopic.KAFKA_MY_TOPIC, KafkaConsumer.class);
    }

    @KafkaListener(topics = { KafkaTopic.KAFKA_MY_TOPIC})
    public void onMessage(String message)
    {
        logger.info("KafkaConsumer主题消息：" + message);
    }
}
