package com.loans.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.loans.dto.LoanRequestDTO;
import com.loans.dto.LoanResponseDTO;
import com.loans.entity.Loan;
import com.loans.exception.LoanNotFoundException;
import com.loans.mapper.LoanMapper;
import com.loans.repository.LoanRepository;

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
