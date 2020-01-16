package com.shev.zm.mq.mq.rocketmq;

import com.shev.zm.mq.common.rocketmq.RocketMQGroup;
import com.shev.zm.mq.common.rocketmq.RocketMQTopic;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = RocketMQTopic.ROCKET_MQ_MY_TOPIC, consumerGroup = RocketMQGroup.ROCKET_MQ_MY_GROUP_BAK)
public class RocketMQTopicConsumer implements RocketMQListener<String>
{
    private static final Logger logger = LoggerFactory.getLogger(RocketMQTopicConsumer.class);

    @Override
    public void onMessage(String message)
    {
        logger.info("RocketMQTopicConsumer主题ROCKET_MQ_MY_GROUP_BAK消息：" + message);
    }
}
