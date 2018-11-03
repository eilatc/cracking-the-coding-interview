package moderate;

import java.util.Arrays;

/**
 * Given two arrays of integers, compute the pair of values (one value in each array)
 * with the smallest (non-negative) difference. Return the difference.
 * <p>
 * EXAMPLE
 * Input: {1, 3, 15, 11, 2}, {23, 127,235, 19, 8}
 * Output: 3. That is, the pair (11, 8).
 */

// If a1 is in length M and a2 in length N then:
// Sorting MlogM + NlogN, iterate M + N. therefore: MlogM + NlogN
public class _16_06_SmallestDifference {

    int findSmallestDiff(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);

        int min = Integer.MAX_VALUE;

        int p1 = 0;
        int p2 = 0;

        while (p1 < a1.length && p2 < a2.length) {
            if ((a1[p1] - a2[p2]) > 0){
                min = Math.min(min, a1[p1] - a2[p2]);
                p2++;
            } else {
                min = Math.min(min, a2[p2] - a1[p1]);
                p1++;
            }
        }

      return min;
    }
}
