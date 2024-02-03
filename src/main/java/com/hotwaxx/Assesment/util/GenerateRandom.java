package com.hotwaxx.Assesment.util;

import java.util.Random;

public class GenerateRandom {
    public String generateValue() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Set the length of the random string you want to generate
        int length = 10;

        // Creating a Random object
        Random random = new Random();

        // Generating a random string
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }

    return randomString.toString() ;
    }
}
