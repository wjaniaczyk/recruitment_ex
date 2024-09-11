package com.wj;

import java.util.*;

public class PlayWithPalindrome {

    public static void main(String[] args) {
        String test = "8199";
//        String test = "90000";
//        String test  = "54321";
//        String test  = "39828";
//        String test = "00909";
//        String test  = "0900009";
//        String test  = "88776";
        System.out.println(findMaxPalindrome(test));
    }

    public static String findMaxPalindrome(String input) {
        String result;
        Set<String> palindromes = new HashSet<>();

        HashMap<Character, Integer> characterWithNumberOfAppearance = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (characterWithNumberOfAppearance.containsKey(c)) {
                characterWithNumberOfAppearance.put(c, characterWithNumberOfAppearance.get(c) + 1);
            } else {
                characterWithNumberOfAppearance.put(c, 1);
            }
        }

        Set<Character> oddCharacters = new HashSet<>();
        for (Map.Entry<Character, Integer> itr : characterWithNumberOfAppearance.entrySet()) {
            if (itr.getValue() % 2 != 0) {
                if (itr.getValue() > 1) {
                    characterWithNumberOfAppearance
                            .replace(itr.getKey(), itr.getValue(), itr.getValue() - 1);
                }
                oddCharacters.add(itr.getKey());
                palindromes.add(String.valueOf(itr.getKey()));
            }
        }

        StringBuilder firstHalf = new StringBuilder();
        StringBuilder lastHalf = new StringBuilder();
        Map<Character, Integer> sortedCharacterWithNumberOfAppearance = new TreeMap<>(Collections.reverseOrder());
        sortedCharacterWithNumberOfAppearance.putAll(characterWithNumberOfAppearance);

        for (Map.Entry<Character, Integer> entry : sortedCharacterWithNumberOfAppearance.entrySet()) {
            StringBuilder substring = new StringBuilder();
            for (int i = 0; i < entry.getValue() / 2; i++) {
                substring.append(entry.getKey());
            }
            firstHalf.append(substring);
            lastHalf.insert(0, substring);

            if (firstHalf.length() > 0 && lastHalf.length() > 0) {
                if (!oddCharacters.isEmpty()) {
                    for (char c : oddCharacters) {
                        result = firstHalf.toString() + c + lastHalf;
                        if (result.charAt(0) != '0') {
                            palindromes.add(result);
                        }
                    }
                } else {
                    result = firstHalf + lastHalf.toString();
                    if (result.charAt(0) != '0') {
                        palindromes.add(result);
                    }
                }
            }
        }

        return palindromes.stream()
                .map(Integer::valueOf)
                .max(Comparator.naturalOrder())
                .map(String::valueOf)
                .orElse("Could not found max palindrome");
    }
}
