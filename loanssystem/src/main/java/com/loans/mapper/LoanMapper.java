package com.loans.mapper;

import java.time.LocalDateTime;

import com.loans.dto.LoanRequestDTO;
import com.loans.dto.LoanResponseDTO;
import com.loans.entity.Loan;

public class LoanMapper {

    // RequestDTO → Entity
    public static Loan toEntity(LoanRequestDTO request) {
        Loan loan = new Loan();
        loan.setAccountNumber(request.getAccountNumber());
        loan.setLoanType(request.getLoanType());
        loan.setLoanAmmount(request.getLoanAmmount());
        loan.setIntrestRate(request.getIntrestRate());
        loan.setTenure(request.getTenure());
        loan.setLoanStatus("APPLIED");
        loan.setBranch(request.getBranch());
        loan.setCreatedAt(LocalDateTime.now());
        return loan;
    }

    // Entity → ResponseDTO
    public static LoanResponseDTO toDTO(Loan loan) {
        LoanResponseDTO dto = new LoanResponseDTO();
        dto.setLoanId(loan.getLoanId());
        dto.setAccountNumber(loan.getAccountNumber());
        dto.setLoanType(loan.getLoanType());
        dto.setLoanAmmount(loan.getLoanAmmount());
        dto.setIntrestRate(loan.getIntrestRate());
        dto.setTenure(loan.getTenure());
        dto.setLoanStatus(loan.getLoanStatus());
        dto.setBranch(loan.getBranch());
        dto.setCreatedAt(loan.getCreatedAt());
        return dto;
    }
}
