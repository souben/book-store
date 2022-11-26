package borrowing.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
public class Borrowing {
    @Id
    private String borrowingNumber;
    private String date;
    private Customer customer;
    private Book book;


    public Borrowing(String borrowingNumber, String date, Customer customer, Book book) {
        this.borrowingNumber = borrowingNumber;
        this.date = date;
        this.customer = customer;
        this.book = book;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
