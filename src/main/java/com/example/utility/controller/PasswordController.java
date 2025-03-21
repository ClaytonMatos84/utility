package com.example.utility.controller;

import com.example.utility.dto.PassDto;
import com.example.utility.service.PasswordService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PasswordController {

    private final PasswordService passwordService;

    @PostMapping(value = "/validate-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void validatePassword(@RequestBody @Valid PassDto passDto) {}

    @GetMapping(value = "/generate-password")
    public PassDto generatePassword() {
        return passwordService.generateRandomPassword();
    }
}
