package com.shev.zm.mq.controller;

import com.alibaba.fastjson.JSONObject;
import com.shev.mq.activemq.service.ActiveMQProducer;
import com.shev.mq.kafka.service.KafkaProducer;
import com.shev.mq.rocketmq.service.RocketMQProducer;
import com.shev.zm.mq.common.activemq.ActiveMQQueue;
import com.shev.zm.mq.common.kafka.KafkaTopic;
import com.shev.zm.mq.common.rocketmq.RocketMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.Topic;
import java.util.Map;

@RequestMapping("/mq")
@RestController
public class MQController
{

    @Autowired
    private ActiveMQProducer activeMQProducer;

    @Autowired
    private Topic myTopic;

    @PostMapping("/sendActiveMQ")
    @ResponseBody
    public String sendActiveMQ(@RequestBody String request)
    {
        Map<String, String> params = (Map<String, String>) JSONObject.parse(request);
        activeMQProducer.sendMessage(ActiveMQQueue.ACTIVE_MQ_MY_QUEUE, params.get("context"));
        activeMQProducer.sendTopicMessage(myTopic, params.get("context"));
        return "success";
    }

    @Autowired
    private RocketMQProducer rocketMQProducer;

    @PostMapping("/sendRocketMQ")
    @ResponseBody
    public String sendRocketMQ(@RequestBody String request)
    {
        Map<String, String> params = (Map<String, String>) JSONObject.parse(request);
        rocketMQProducer.sendMessage(RocketMQTopic.ROCKET_MQ_MY_TOPIC, params.get("context"));
        return "success";
    }

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/sendKafka")
    @ResponseBody
    public String sendKafka(@RequestBody String request)
    {
        kafkaProducer.send(KafkaTopic.KAFKA_MY_TOPIC_BAK, request);
        return "success";
    }

    @PostMapping("/sendBatchKafka")
    @ResponseBody
    public String sendBatchKafka(@RequestBody String request)
    {
        kafkaProducer.send(KafkaTopic.KAFKA_MY_TOPIC, request);
        return "success";
    }

}
