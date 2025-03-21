package com.example.utility.controller;

import com.example.utility.dto.PassDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @PostMapping(value = "/validate-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void validatePassword(@RequestBody @Valid PassDto passDto) {}
}
