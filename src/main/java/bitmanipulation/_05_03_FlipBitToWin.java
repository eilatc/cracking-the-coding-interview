package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * You have an integer and you can flip exactly one bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of 1s you could create.
 * <p>
 * EXAMPLE
 * Input: 1775 (or: 11011101111)
 * Output: 8
 */
class _05_03_FlipBitToWin {
    int flip(int n) {
        List<Integer> sequences  = countSequences(n);
        int max = 0;

        // First we count zeros and then ones
        for (int i = 0 ; i < sequences.size() ; i=i+2) {
            int leftOnes = (i - 1) > 0 ? sequences.get(i-1) : 0;
            int rightOnes = (i + 1) < sequences.size() ? sequences.get(i+1) : 0;
            int zeroSequence = sequences.get(i);
            int currentMax;
            if (zeroSequence == 1) {
                currentMax = leftOnes + rightOnes + 1;
            } else if (zeroSequence > 1) {
                currentMax = Math.max(leftOnes, rightOnes) + 1;
            } else {
                currentMax = Math.max(leftOnes, rightOnes);
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }
    List<Integer> countSequences(int n) {
        List<Integer> seq = new ArrayList<>();
        int lookingFor = 0;
        int count = 0;
        System.out.println(Integer.toBinaryString(n));
        for (int i = 0 ; i < Integer.SIZE ; i++) {
            int bit = (n >> i) & 1;
            if (bit != lookingFor) {
                seq.add(count);
                lookingFor = bit;
                count = 0;
            }
            count++;
        }
        seq.add(count);

        return seq;
    }



}
