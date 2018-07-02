import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.log4j.Log4j2;
import shared.Message;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Producer is created to propose the way of how to send the message with statement.
 *@author kozlojak
 */

@Log4j2
public class Producer {

    private static final String QUEUE_NAME = "statement_queue";

    public static void produce(Message<?> message) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String jsonMessage = new ObjectMapper().writeValueAsString(message);

        channel.queueDeclare(jsonMessage, false, false, false, null);
        channel.basicPublish("", QUEUE_NAME, null, jsonMessage.getBytes());
        log.info(" [x] Sent ");
        channel.close();
        connection.close();
    }
}
