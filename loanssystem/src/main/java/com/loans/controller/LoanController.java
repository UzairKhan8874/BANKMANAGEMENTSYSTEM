package com.loans.controller;

import com.loans.dto.LoanRequestDTO;
import com.loans.dto.LoanResponseDTO;
import com.loans.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
