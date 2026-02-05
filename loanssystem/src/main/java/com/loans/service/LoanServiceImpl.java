package com.loans.service;

import com.loans.dto.*;
import com.loans.entity.Loan;
import com.loans.exception.LoanNotFoundException;
import com.loans.mapper.LoanMapper;
import com.loans.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public LoanResponseDTO applyLoan(LoanRequestDTO request) {
        Loan loan = LoanMapper.toEntity(request);
        return LoanMapper.toDTO(loanRepository.save(loan));
    }

    @Override
    public List<LoanResponseDTO> getLoansByAccount(Long accountNumber) {
        return loanRepository.findByAccountNumber(accountNumber)
                .stream()
                .map(LoanMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void closeLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found"));
        loan.setLoanStatus("CLOSED");
        loanRepository.save(loan);
    }
}
