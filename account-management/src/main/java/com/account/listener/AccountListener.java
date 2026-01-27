package com.account.listener;

import com.account.entity.Account;

import jakarta.persistence.PrePersist;

public class AccountListener {
    @PrePersist
    public void beforeSave(Account acc) {
        System.out.println("Saving: " + acc.getName());
    }
}