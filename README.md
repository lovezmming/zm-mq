# zm-mq  
多种类型mq的应用  

add(2019-12-12)  
1.新增activemq  
  环境：  
  centos7 + activemq5.15.1 + jdk1.8  + intelliJ IDEA  
  启动指令：  
     cd ../bin  
     ./activemq start  
  停止指令：  
     ./activemq stop  
  1）基础实现消息推送  
    问题：topic与queue并存  
    配置可区分queue与topic：jms.pub-sub-domain=false  
    说明：false：queue，true：topoc  
    解决：不需要配置该参数，在mq的config中进行topic配置  
2.新增kafka、rabbitmq、rocketmq包  
  
update(2019-12-16)  
1.调整activemq
  调整activemq为组件jar包支持service开发  
  
add(2019-12-18)  
1.新增rocketmq实现  
  环境：  
  centos7 + rocketmq4.3.0 + jdk8 + intelliJ IDEA  
  启动指令：  
     cd ../bin  
     nohup sh mqnamesrv &  
     nohup sh mqbroker -n localhost:9876 &  
  停止指令：  
     sh mqshutdown broker  
     sh mqshutdown namesrv  
  1)实现消息的推送
  

  
   
    


