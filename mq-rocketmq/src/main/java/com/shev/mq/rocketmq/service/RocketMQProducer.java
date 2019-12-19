package com.shev.mq.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rocketMQProducer")
@Slf4j
public class RocketMQProducer
{

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public Boolean sendMessage(String destination, String message)
    {
        try
        {
            rocketMQTemplate.syncSend(destination, message);
        } catch (Exception e)
        {
            log.error("rocketmq send error ! " + e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
