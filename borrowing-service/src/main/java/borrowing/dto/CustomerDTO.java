package borrowing.dto;

public class CustomerDTO {
    private String customerNumber;
    private String name;
    private String street;
    private String city;
    private String zip;
    private String email;
    private String phone;

    public CustomerDTO() {}
    public CustomerDTO(String customerNumber, String name, String street ,
                       String city, String zip, String email, String phone){
        this.customerNumber = customerNumber;
        this.name = name;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerNumber='" + customerNumber + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
