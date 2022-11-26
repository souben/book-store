package customers.integration;

import customers.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class Sender {

    @Autowired
    private KafkaTemplate<String, CustomerDTO> kafkaTemplate;

    public void send(String topic, String key, CustomerDTO customerDTO) {

        kafkaTemplate.send(topic, key, customerDTO);
    }

}
