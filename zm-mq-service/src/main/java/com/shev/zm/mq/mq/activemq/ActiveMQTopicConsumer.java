package com.shev.zm.mq.mq.activemq;

import com.shev.mq.activemq.config.ActiveMQConfig;
import com.shev.zm.mq.common.activemq.ActiveMQQueue;
import com.shev.zm.mq.common.activemq.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQTopicConsumer
{
    private static final Logger logger = LoggerFactory.getLogger(ActiveMQTopicConsumer.class);

    @JmsListener(destination= ActiveMQQueue.ACTIVE_MQ_MY_QUEUE)
    public void ListenMyQueue(String msg)
    {
        logger.info("ActiveMQTopicConsumer接收到queue消息：" + msg);
    }

    @JmsListener(destination= ActiveMQTopic.ACTIVE_MQ_MY_TOPIC, containerFactory = ActiveMQConfig.TOPIC_FACTORY)
    public void ListenMyTopic(String msg)
    {
        logger.info("ActiveMQTopicConsumer接收到topic消息：" + msg);
    }
}
