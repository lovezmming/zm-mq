package com.shev.zm.mq.activemq.mq;

import com.shev.zm.mq.common.constant.MqTopic;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQTopicConsumer
{

    @JmsListener(destination=MqTopic.ACTIVE_MQ_TOPIC, containerFactory = "jmsTopicListenerContainerFactory")
    public void ListenTopic(String msg)
    {
        System.out.println("接收到topic-2消息：" + msg);
    }

}
