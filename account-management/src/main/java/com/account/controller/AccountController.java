package com.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.dto.AccountRequestDTO;
import com.account.response.ApiResponse;
import com.account.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<?> create(@Valid @RequestBody AccountRequestDTO dto) {
        return new ApiResponse<>(true, "Account created", service.save(dto));
    }

    @GetMapping
    public ApiResponse<?> getAll() {
        return new ApiResponse<>(true, "All accounts", service.getAll());
    }
}