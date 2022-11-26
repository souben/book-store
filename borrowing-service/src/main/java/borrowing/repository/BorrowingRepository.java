package borrowing.repository;

import borrowing.domain.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends MongoRepository<Borrowing, String>{
    @Query("{'customer.customerNumber': ?0}")
    Borrowing findByBorrowing(String customerNumber);
}
