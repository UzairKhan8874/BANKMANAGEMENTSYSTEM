package com.account.mapper;

import com.account.dto.AccountRequestDTO;
import com.account.entity.Account;

public class AccountMapper {
    public static Account toEntity(AccountRequestDTO dto) {
        Account acc = new Account();
        acc.setName(dto.getName());
        acc.setEmail(dto.getEmail());
        return acc;
    }
}