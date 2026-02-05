package com.loans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loans.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByAccountNumber(Long accountNumber); // Ye method Service me use ho raha
}
