package com.loans.service;

import java.util.List;

import com.loans.dto.LoanRequestDTO;
import com.loans.dto.LoanResponseDTO;

public interface LoanService {

    LoanResponseDTO applyLoan(LoanRequestDTO request);
    List<LoanResponseDTO> getLoansByAccount(Long accountNumber);
    void closeLoan(Long loanId);
}
