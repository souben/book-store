package borrowing.dto;

import borrowing.domain.Borrowing;

import java.util.Date;

public class BorrowingDTO {
    private String borrowingNumber;
    private String date;
    private String isbn;
    private String title;
    private String customerNumber;
    private String name;

    public BorrowingDTO(){}

    public BorrowingDTO(String borrowingNumber, String date, String isbn, String title, String customerNumber, String name) {
        this.borrowingNumber = borrowingNumber;
        this.date = date;
        this.isbn = isbn;
        this.title = title;
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public String getBorrowingNumber() {
        return borrowingNumber;
    }

    public void setBorrowingNumber(String borrowingNumber) {
        this.borrowingNumber = borrowingNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
