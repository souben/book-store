package customers.dto;

import customers.domain.Address;
import customers.domain.ContactInfo;
import customers.domain.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerDTOAdapter {

    public Customer getCustomerFromCustomerDTO(CustomerDTO customerDTO){
        Address address = new Address(customerDTO.getStreet(), customerDTO.getCity(), customerDTO.getZip());
        ContactInfo contactInfo = new ContactInfo(customerDTO.getEmail(), customerDTO.getPhone());
        String customerNumber = customerDTO.getCustomerNumber();
        String name = customerDTO.getName();
        return new Customer(customerNumber, name, address, contactInfo);
    }


    public CustomerDTO getCustomerDTOFromCustomer(Customer customer){
        String customerNumber, name, street, city, zip, email, phone;
        customerNumber = customer.getCustomerNumber();
        name = customer.getName();
        street = customer.getAddress().getStreet();
        city = customer.getAddress().getCity();
        zip = customer.getAddress().getZip();
        phone = customer.getContactInfo().getPhone();
        email = customer.getContactInfo().getEmail();
        return new CustomerDTO(customerNumber, name , street, city, zip, email, phone);
    }
}
