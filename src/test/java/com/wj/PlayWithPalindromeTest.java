package com.wj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayWithPalindromeTest {

    PlayWithPalindrome playWithPalindrome = new PlayWithPalindrome();

    @Test
    void shouldReturn989() {
        String test = "8199";
        String maxPalindrome = playWithPalindrome.findMaxPalindrome(test);
        Assertions.assertEquals("989", maxPalindrome);
    }

    @Test
    void shouldReturn9() {
        String test = "90000";
        String maxPalindrome = playWithPalindrome.findMaxPalindrome(test);
        Assertions.assertEquals("9", maxPalindrome);
    }

    @Test
    void shouldReturn5() {
        String test = "54321";
        String maxPalindrome = playWithPalindrome.findMaxPalindrome(test);
        Assertions.assertEquals("5", maxPalindrome);
    }

    @Test
    void shouldReturn898() {
        String test = "39828";
        String maxPalindrome = playWithPalindrome.findMaxPalindrome(test);
        Assertions.assertEquals("898", maxPalindrome);
    }

    @Test
    void shouldReturn90009() {
        String test = "00909";
        String maxPalindrome = playWithPalindrome.findMaxPalindrome(test);
        Assertions.assertEquals("90009", maxPalindrome);
    }

    @Test
    void shouldReturn9000009() {
        String test = "0900009";
        String maxPalindrome = playWithPalindrome.findMaxPalindrome(test);
        Assertions.assertEquals("9000009", maxPalindrome);
    }

    @Test
    void shouldReturn87678() {
        String test = "88776";
        String maxPalindrome = playWithPalindrome.findMaxPalindrome(test);
        Assertions.assertEquals("87678", maxPalindrome);
    }
}