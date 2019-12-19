package com.shev.zm.mq.mq.rocketmq;

import com.shev.zm.mq.common.rocketmq.RocketMQGroup;
import com.shev.zm.mq.common.rocketmq.RocketMQTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = RocketMQTopic.ROCKET_MQ_MY_TOPIC, consumerGroup = RocketMQGroup.ROCKET_MQ_MY_GROUP_BAK)
public class RocketMQTopicConsumer implements RocketMQListener<String>
{
    @Override
    public void onMessage(String message)
    {
        log.info("RocketMQTopicConsumer主题ROCKET_MQ_MY_GROUP_BAK消息：" + message);
    }
}
