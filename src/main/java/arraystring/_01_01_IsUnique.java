package arraystring;

import java.util.HashSet;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * Not just alphabet, any character
 */

class _01_01_IsUnique {

    boolean isUnique(String str) {

        HashSet<Character> set = new HashSet<>();

        for (int i=0 ; i < str.length() ; i++) {
            if (set.contains(str.charAt(i))) {
                return false;
            } else {
                set.add(str.charAt(i));
            }
        }
        return true;

    }


}
