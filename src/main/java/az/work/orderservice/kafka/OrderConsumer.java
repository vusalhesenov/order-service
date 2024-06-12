package az.work.orderservice.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}