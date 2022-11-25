package customers.integration;
import customers.dto.CustomerDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @KafkaListener(topics="customerchange")
	public void receive(@Payload CustomerDTO customerDTO, @Headers MessageHeaders headers){
		System.out.println("here");
		System.out.println("I received one message : " + customerDTO);
	}
}
