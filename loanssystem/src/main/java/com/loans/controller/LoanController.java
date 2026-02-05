package com.loans.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loans.dto.LoanRequestDTO;
import com.loans.dto.LoanResponseDTO;
import com.loans.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // 1️⃣ Apply Loan
    @PostMapping
    public ResponseEntity<LoanResponseDTO> applyLoan(@RequestBody LoanRequestDTO request) {
        LoanResponseDTO response = loanService.applyLoan(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 2️⃣ Get all loans for an account
    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<List<LoanResponseDTO>> getLoansByAccount(@PathVariable Long accountNumber) {
        List<LoanResponseDTO> loans = loanService.getLoansByAccount(accountNumber);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    // 3️⃣ Close a loan
    @PutMapping("/{loanId}/close")
    public ResponseEntity<String> closeLoan(@PathVariable Long loanId) {
        loanService.closeLoan(loanId);
        return new ResponseEntity<>("Loan closed successfully", HttpStatus.OK);
    }
}
