package borrowing.service;


import borrowing.domain.Borrowing;
import borrowing.dto.BorrowingDTO;
import borrowing.dto.BorrowingDTOAdapter;
import borrowing.repository.BorrowingRepository;
import org.apache.kafka.clients.producer.internals.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowingService {


    @Autowired
    BorrowingRepository borrowingRepository; 

    @Autowired
    BorrowingDTOAdapter borrowingDTOAdapter;

    //  GET Consumer
    public Optional<Borrowing> getBorrowing(String borrowingNumber) {
        return borrowingRepository.findById(borrowingNumber);
    }

    // ADD consumer
    public Borrowing addBorrowing(BorrowingDTO borrowingDTO){
        Borrowing borrowing = borrowingDTOAdapter.fromDTO(borrowingDTO);
        Borrowing record  = (Borrowing) borrowingRepository.save(borrowing);
        return record;
    }

    // POST consumer
    public Optional<Borrowing> updateBorrowing(String borrowingNumber, BorrowingDTO borrowingDTO){
        Optional<Borrowing> record = borrowingRepository.findById(borrowingNumber);
        Optional<Borrowing> newRecord = Optional.empty();
        if(record.isPresent()){
            Borrowing borrowing = borrowingDTOAdapter.fromDTO(borrowingDTO);
            newRecord = Optional.of((Borrowing) borrowingRepository.save(borrowing));
        }
        return newRecord;
    }

    // DELETE consumer
    public void deleteBorrowing(String borrowingNumber) {
        Optional<Borrowing> record = borrowingRepository.findById(borrowingNumber);
        borrowingRepository.deleteById(borrowingNumber);
        if (record.isPresent()) {
            BorrowingDTO borrowingDTO = borrowingDTOAdapter.toDTO(record.get());
        }
    }
}
