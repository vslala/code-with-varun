package com.codewithvarun.problemsolving;

import java.util.HashSet;

public class ArraysAndStrings {

    public boolean determineIfInputHasAllUniqueCharacters(String input) {
        var charSet = new HashSet<Character>();
        int i = 0;
        while (i < input.length()) {
            if (charSet.contains(input.charAt(i))) {
                return false;
            } else {
                charSet.add(input.charAt(i));
            }
            i++;
        }
        return true;
    }

    // 0, 1 = false
    // 1, 1 = true
    // 1, 0 = false
    // 0, 0  = false
    public boolean determineIfInputHasAllUniqueCharactersOptimized(String input) {
        int checker = 0;
        int i = 0;
        while (i < input.length()) {
            var value = input.charAt(i) - 'a';
            if ((checker & (1 << value)) > 0) return false;
            checker = checker | (1 << value);
            i++;
        }
        return true;
    }
}
