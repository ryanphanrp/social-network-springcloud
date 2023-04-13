package com.ryan.utils;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class PasswordUtils {

    private static final int DEFAULT_LENGTH = 10;
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER = "!@#$%&*()_+-=[]?";
    private static final String BASE = LOWER + UPPER + NUMBER + OTHER;

    private PasswordUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String generatePassword() {
        return generatePassword(DEFAULT_LENGTH);
    }

    public static String generatePassword(long length) {
        SecureRandom random = new SecureRandom();
        return random.ints(length, 0, BASE.length())
            .mapToObj(BASE::charAt).map(Object::toString)
            .collect(Collectors.joining());
    }
}
