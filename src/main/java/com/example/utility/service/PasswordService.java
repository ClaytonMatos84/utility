package com.example.utility.service;

import com.example.utility.dto.PassDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PasswordService {

    public PassDto generateRandomPassword() {
        Random passRandom = new Random();
        int targetStringLength = passRandom.nextInt(10, 16);
        String pass = getRandomString(passRandom, targetStringLength);

        pass = addPassNumber(passRandom, pass);
        pass = addPassUpperCase(passRandom, pass);
        pass = addPassSpecialCharacter(passRandom, pass);

        return new PassDto(pass);
    }

    private String getRandomString(Random random, int stringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        return random.ints(leftLimit, rightLimit + 1).limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String addPassNumber(Random passRandom, String pass) {
        int addInt = passRandom.nextInt(2, 6);
        for (int i = 0; i < addInt; i++) {
            int randomInt = passRandom.nextInt(10, 100);
            int maxAddLength = passRandom.nextInt(3, pass.length());
            String newPass = pass.substring(0, maxAddLength) + randomInt;
            pass = newPass + pass.substring(maxAddLength);
        }
        return pass;
    }

    private String addPassUpperCase(Random passRandom, String pass) {
        int addUpperCase = passRandom.nextInt(1, 3);
        for (int i = 0; i < addUpperCase; i++) {
            String randomString = getRandomString(passRandom, 1);
            int maxAddLength = passRandom.nextInt(3, pass.length());
            String newPass = pass.substring(0, maxAddLength) + randomString.toUpperCase();
            pass = newPass + pass.substring(maxAddLength);
        }
        return pass;
    }

    private static String addPassSpecialCharacter(Random passRandom, String pass) {
        List<String> special = Arrays.asList("!", "#", "$", "%", "-", "&", "@");
        int addSpecial = passRandom.nextInt(1, 3);
        for (int i = 0; i < addSpecial; i++) {
            String randomString = special.get(passRandom.nextInt(special.size()));
            int maxAddLength = passRandom.nextInt(3, pass.length());
            String newPass = pass.substring(0, maxAddLength) + randomString.toUpperCase();
            pass = newPass + pass.substring(maxAddLength);
        }
        return pass;
    }
}
