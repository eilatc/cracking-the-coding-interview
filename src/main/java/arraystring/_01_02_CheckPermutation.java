package arraystring;

/**
 * Given two strings,write a method to decide if one is a permutation of the other.
 * For Example: abcd is permutation of dcba
 */
class _01_02_CheckPermutation {
    boolean check(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] charArray = new int[128];

        for (int i=0 ; i < a.length() ; i++) {

            charArray[a.charAt(i)]++;

        }

        for (int i=0 ; i < b.length() ; i++) {

            if (--charArray[b.charAt(i)] < 0) {
                return false;
            }

        }

        return true;

    }
}
