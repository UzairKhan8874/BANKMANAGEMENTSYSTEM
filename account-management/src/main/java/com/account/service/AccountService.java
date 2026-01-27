package com.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.account.dto.AccountRequestDTO;
import com.account.entity.Account;
import com.account.mapper.AccountMapper;
import com.account.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account save(AccountRequestDTO dto) {
        return repository.save(AccountMapper.toEntity(dto));
    }

    public List<Account> getAll() {
        return repository.findAll();
    }
}