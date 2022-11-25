package customers;

import customers.domain.Customer;
import customers.dto.CustomerDTO;
import customers.dto.CustomerDTOAdapter;
import customers.integration.Sender;
import customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@EnableKafka
@EnableAutoConfiguration
public class CustomerServiceApplication implements CommandLineRunner {

	@Autowired
	Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		CustomerDTO customerDTO = new CustomerDTO("1", "Ali", "North", "Fairfield", "52275", "a@gmail.com", "415266354547");
        System.out.println("Sending message ...");
		sender.send("customerchange", customerDTO);
		System.out.println("data sent");
	}


}



