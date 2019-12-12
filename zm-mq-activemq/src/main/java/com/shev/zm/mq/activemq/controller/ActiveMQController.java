package com.shev.zm.mq.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class ActiveMQController
{

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @PostMapping("sendMQ")
    @ResponseBody
    public String sendMQ(@RequestBody String request)
    {
        jmsMessagingTemplate.convertAndSend(queue, request);
        jmsMessagingTemplate.convertAndSend(topic, request);
        return "success";
    }
}
