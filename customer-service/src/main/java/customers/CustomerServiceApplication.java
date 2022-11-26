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
public class CustomerServiceApplication {

	@Autowired
	Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}



