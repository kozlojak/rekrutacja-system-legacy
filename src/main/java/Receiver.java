import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import converter.AMGConverterImpl;
import converter.ModelMapperConverter;
import factory.StatementFactory;
import lombok.extern.log4j.Log4j2;
import shared.Message;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *@author kozlojak
 */

@Log4j2
public class Receiver {

    private static final String QUEUE_NAME = "statement_queue";

    public static void receive() throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                parseStatement(message);

            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
        log.info("[x] Received");
    }

    @SuppressWarnings(value = "unchecked")
    static void parseStatement(String message) throws IOException {
        ModelMapperConverter modelMapperConverter= new AMGConverterImpl();
        Message messageObject = new ObjectMapper().readValue(message, Message.class);
//        Class<?> type = messageObject.getType().getClazz();
        StatementFactory.getParser(messageObject.getType()).parseMessage(modelMapperConverter.convertEntity(messageObject.getContent()));
    }

}