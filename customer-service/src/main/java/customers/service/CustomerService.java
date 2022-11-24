package customers.service;


import customers.domain.Customer;
import customers.dto.CustomerDTO;
import customers.dto.CustomerDTOAdapter;
import customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerDTOAdapter customerDTOAdapter;

    //  GET Consumer
    public Optional<Customer> getCustomer(String customerNumber) {
        return customerRepository.findById(customerNumber);
    }

    // ADD consumer
    public Customer addCustomer(CustomerDTO customerDTO){
        Customer customer = customerDTOAdapter.getCustomerFromCustomerDTO(customerDTO);
        return (Customer) customerRepository.save(customer);
    }

    // POST consumer
    public Optional<Customer> updateCustomer(String customerNumber, CustomerDTO customerDTO){
        Optional<Customer> record = customerRepository.findById(customerNumber);
        Optional<Customer> newRecord = Optional.empty();
        if(record.isPresent()){
            Customer customer = customerDTOAdapter.getCustomerFromCustomerDTO(customerDTO);
            newRecord = Optional.of((Customer) customerRepository.save(customer));
        }
        return newRecord;
    }

    // DELETE consumer
    public void deleteCustomer(String customerNumber){
        customerRepository.deleteById(customerNumber);
    }
}
