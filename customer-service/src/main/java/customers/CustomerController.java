package customers;

import customers.domain.Customer;
import customers.dto.CustomerDTO;
import customers.dto.CustomerDTOAdapter;
import customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerDTOAdapter customerDTOAdapter;

    @GetMapping("/customers/{customerNumber}")
    public ResponseEntity<?> get(@PathVariable String customerNumber){
        Optional<Customer> customer= customerService.getCustomer(customerNumber);
        CustomerDTO customerDTO = null;
        if(customer.isPresent()) {
            customerDTO = customerDTOAdapter.getCustomerDTOFromCustomer(customer.get());
            System.out.println("fetching customer data :" + customerDTO);
        }
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> add(@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        System.out.println("the customer is added");
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
    @PutMapping("/customers/{customerNumber}")
    public ResponseEntity<?> update(@PathVariable String customerNumber, @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerNumber, customerDTO);
        System.out.println("the customer is updated");
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{customerNumber}")
    public ResponseEntity<?> delete(@PathVariable String customerNumber){
        customerService.deleteCustomer(customerNumber);
        System.out.println("the customer is deleted");
        return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
    }
}
