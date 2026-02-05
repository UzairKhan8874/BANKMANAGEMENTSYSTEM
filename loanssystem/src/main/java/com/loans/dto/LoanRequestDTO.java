package com.loans.dto;

public class LoanRequestDTO {
    private Long accountNumber;
    private String loanType;
    private double loanAmmount;
    private double intrestRate;
    private int tenure;
    private String branch;

    // Getters & Setters
    public Long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public double getLoanAmmount() { return loanAmmount; }
    public void setLoanAmmount(double loanAmmount) { this.loanAmmount = loanAmmount; }

    public double getIntrestRate() { return intrestRate; }
    public void setIntrestRate(double intrestRate) { this.intrestRate = intrestRate; }

    public int getTenure() { return tenure; }
    public void setTenure(int tenure) { this.tenure = tenure; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }
}
