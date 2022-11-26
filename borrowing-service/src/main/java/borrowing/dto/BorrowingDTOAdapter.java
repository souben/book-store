package borrowing.dto;

import borrowing.domain.Book;
import borrowing.domain.Borrowing;
import borrowing.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class BorrowingDTOAdapter {

    public Borrowing fromDTO(BorrowingDTO borrowingDTO) {
        Book book = new Book(borrowingDTO.getIsbn(), borrowingDTO.getTitle());
        Customer customer = new Customer(borrowingDTO.getCustomerNumber(), borrowingDTO.getName());
        String borrowingNumber = borrowingDTO.getBorrowingNumber();
        String date = borrowingDTO.getDate();
        return new Borrowing(borrowingNumber, date, customer, book);
    }


    public BorrowingDTO toDTO(Borrowing borrowing) {
        String borrowingNumber = borrowing.getBorrowingNumber();
        String date = borrowing.getDate();
        String isbn = borrowing.getBook().getIsbn();
        String title = borrowing.getBook().getTitle();
        String customerNumber = borrowing.getCustomer().getCustomerNumber();
        String name = borrowing.getCustomer().getName();
        return new BorrowingDTO(borrowingNumber, date, isbn, title, customerNumber, name);
    }
}
