package org.example;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class SyncProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer mqProducer = new DefaultMQProducer("SyncProducer");
        mqProducer.setNamesrvAddr("xx.xx.xx.xx");
        mqProducer.start();
        for (int i=0; i<2; i++) {
            Message msg = new Message("Sample", "Tags","Test".getBytes());
            SendResult result = mqProducer.send(msg);
        }
        mqProducer.shutdown();
    }
}
