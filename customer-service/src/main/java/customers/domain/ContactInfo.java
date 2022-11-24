package customers.domain;

import java.awt.event.ContainerAdapter;

public final class ContactInfo {
    private final String email;
    private final String phone;

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void validate(String email, String phone){
        return;
    }
    public ContactInfo(String email, String phone) {
        validate(email, phone);
        this.email = email;
        this.phone = phone;
    }

    public ContactInfo updateEmail(String email){
        return new ContactInfo(email, this.phone);
    }

    public ContactInfo updatePhone(String phone){
        return new ContactInfo(this.email, phone);
    }
}
