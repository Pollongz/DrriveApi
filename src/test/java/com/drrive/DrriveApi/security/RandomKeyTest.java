package com.drrive.DrriveApi.security;

import org.junit.jupiter.api.Test;

class RandomKeyTest {

    @Test
    public void generateRandomKeyTest() {

        for (int i = 0; i < 5; i++) {
            String alphanumeric = RandomKey.generateRandomKey(10);
            System.out.println(alphanumeric);
        }
    }
}