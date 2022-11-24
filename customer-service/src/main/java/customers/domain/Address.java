package customers.domain;

public final class Address {
    private final String street;
    private final String city;
    private final String zip;

    public Address(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public Address updateCity(String city) {
        return new Address(this.street, this.zip, city);
    }

    public Address updateZip(String zip) {
        return new Address(this.street, zip, this.city);
    }

    public Address setStreet(String street) {
        return new Address(street, this.zip, this.city);
    }

}
