package demo.demo2;

import javax.jms.*;

/**
 * 通过 实现 MessageListener 的 onMessage 来监听消息 
 * 接受、处理消息
 * @author flm
 * @2017年10月16日
 */
public class AMQ implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                System.out.println("== 收到一个JMS消息..." + msg.getText());
            } 
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}