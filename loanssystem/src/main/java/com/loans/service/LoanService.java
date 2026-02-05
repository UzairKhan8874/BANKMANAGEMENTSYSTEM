package com.loans.service;

import com.loans.dto.*;
import java.util.List;

public interface LoanService {

    LoanResponseDTO applyLoan(LoanRequestDTO request);
    List<LoanResponseDTO> getLoansByAccount(Long accountNumber);
    void closeLoan(Long loanId);
}
