package borrowing.integration;
import borrowing.domain.Customer;
import borrowing.dto.CustomerDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @KafkaListener(topics="customerchange")
	void listener(ConsumerRecord<String, CustomerDTO> record){
		System.out.println("received message of type : "+ record.key());
		System.out.println("value of received message is : " + record.value());
	}
}
