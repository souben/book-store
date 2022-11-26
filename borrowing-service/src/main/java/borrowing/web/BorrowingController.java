package borrowing.web;


import borrowing.domain.Borrowing;
import borrowing.dto.BorrowingDTO;
import borrowing.dto.BorrowingDTOAdapter;
import borrowing.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BorrowingController {
    @Autowired
    BorrowingService borrowingService;

    @Autowired
    BorrowingDTOAdapter borrowingDTOAdapter;

    @GetMapping("/borrowings/{borrowingNumber}")
    public ResponseEntity<?> get(@PathVariable String borrowingNumber){
        Optional<Borrowing> borrowing= borrowingService.getBorrowing(borrowingNumber);
        BorrowingDTO borrowingDTO = null;
        if(borrowing.isPresent()) {
            borrowingDTO = borrowingDTOAdapter.toDTO(borrowing.get());
            System.out.println("fetching borrowing data :" + borrowingDTO);
        }
        return new ResponseEntity<>(borrowingDTO, HttpStatus.OK);
    }

    @PostMapping("/borrowings")
    public ResponseEntity<?> add(@RequestBody BorrowingDTO borrowingDTO){
        System.out.println("starting the service ...");
        borrowingService.addBorrowing(borrowingDTO);
        System.out.println("the borrowing is added");
        return new ResponseEntity<>(borrowingDTO, HttpStatus.OK);
    }
    @PutMapping("/borrowings/{borrowingNumber}")
    public ResponseEntity<?> update(@PathVariable String borrowingNumber, @RequestBody BorrowingDTO borrowingDTO){
        borrowingService.updateBorrowing(borrowingNumber, borrowingDTO);
        System.out.println("the borrowing is updated");
        return new ResponseEntity<>(borrowingDTO, HttpStatus.OK);
    }

    @DeleteMapping("/borrowings/{borrowingNumber}")
    public ResponseEntity<?> delete(@PathVariable String borrowingNumber){
        borrowingService.deleteBorrowing(borrowingNumber);
        System.out.println("the borrowing is deleted");
        return new ResponseEntity<BorrowingDTO>(HttpStatus.OK);
    }
}
