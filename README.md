# zm-mq  
多种类型mq的应用  

add(2019-12-12)  
1.新增activemq  
  环境：  
  centos7 + activemq5.15.1 + jdk1.8  + intelliJ IDEA  
  1）基础实现消息推送  
    问题：topic与queue并存  
    配置可区分queue与topic：jms.pub-sub-domain=false  
    说明：false：queue，true：topoc  
    解决：不需要配置该参数，在mq的config中进行topic配置  
2.新增kafka、rabbitmq、rocketmq包  
  
update(2019-12-16)  
1.调整activemq
  调整activemq为组件jar包支持service开发  


    


