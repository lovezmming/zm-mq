package com.shev.zm.mq.mq.kafka;

import com.shev.mq.kafka.handler.KafkaTopicConsumeHandler;
import com.shev.zm.mq.common.kafka.KafkaTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaBakConsumer extends KafkaTopicConsumeHandler
{
    private static final Logger logger = LoggerFactory.getLogger(KafkaBakConsumer.class);

    public KafkaBakConsumer()
    {
        super(null, KafkaTopic.KAFKA_MY_TOPIC, KafkaBakConsumer.class);
    }

    @KafkaListener(topics = {KafkaTopic.KAFKA_MY_TOPIC})
    public void onMessage(String message)
    {
        logger.info("KafkaBakConsumer主题消息：" + message);
    }
}
