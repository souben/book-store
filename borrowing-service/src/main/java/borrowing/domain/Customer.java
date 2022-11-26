package borrowing.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Customer {
    private final String customerNumber;
    private final String name;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public Customer updateCustomerNumber(String customerNumber) {
        return new Customer(customerNumber, this.name);
    }

    public Customer(String customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer updateName(String name) {
        return new Customer(this.customerNumber, name);
    }
}

