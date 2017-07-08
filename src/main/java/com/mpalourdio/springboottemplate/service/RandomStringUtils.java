package com.mpalourdio.springboottemplate.service;

import org.apache.commons.text.RandomStringGenerator;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

final public class RandomStringUtils {

    private RandomStringUtils() {
    }

    public static String randomAlphaNumeric(final int length) {
        return new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(LETTERS, DIGITS)
                .build()
                .generate(length)
                .toLowerCase();
    }

    public static String randomAlphabetic(final int length) {
        return new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .build()
                .generate(length);
    }

    public static String randomNumeric(final int length) {
        return new RandomStringGenerator.Builder()
                .withinRange('0', '9')
                .build()
                .generate(length);
    }
}
