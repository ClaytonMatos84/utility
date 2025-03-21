package com.example.utility.service;

import com.example.utility.dto.PassDto;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PasswordService {

    public PassDto generateRandomPassword() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random passRandom = new Random();
        int targetStringLength = passRandom.nextInt(10, 20);

        String pass = passRandom.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        int addInt = passRandom.nextInt(1, 8);
        StringBuilder newPass = new StringBuilder();
        for (int i = 0; i < addInt; i++) {
            int randomInt = passRandom.nextInt(10, 100);
            int maxAddLength = passRandom.nextInt(3, targetStringLength);
            newPass.append(pass, 1, maxAddLength).append(randomInt);
        }

        return new PassDto(newPass.substring(0, targetStringLength));
    }
}
