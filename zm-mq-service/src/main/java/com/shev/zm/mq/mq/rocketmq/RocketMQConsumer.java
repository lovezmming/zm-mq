package com.shev.zm.mq.mq.rocketmq;

import com.shev.zm.mq.common.rocketmq.RocketMQGroup;
import com.shev.zm.mq.common.rocketmq.RocketMQTopic;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = RocketMQTopic.ROCKET_MQ_MY_TOPIC, consumerGroup = RocketMQGroup.ROCKET_MQ_MY_GROUP)
public class RocketMQConsumer implements RocketMQListener<String>
{
    private static final Logger logger = LoggerFactory.getLogger(RocketMQConsumer.class);

    @Override
    public void onMessage(String message)
    {
        logger.info("RocketMQConsumer主题ROCKET_MQ_MY_GROUP消息：" + message);
    }
}
