package com.loans.repository;

import com.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByAccountNumber(Long accountNumber); // Ye method Service me use ho raha
}
