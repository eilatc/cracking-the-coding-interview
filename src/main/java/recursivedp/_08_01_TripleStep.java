package recursivedp;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
class _08_01_TripleStep {

    int countWays(int steps) {
        if (steps == 0) { return 1; }
        if (steps < 0) { return 0; }

        return countWays(steps-3) + countWays(steps-2) + countWays(steps-1);
    }

    // Using Dynamic Programming

    int dynamicCountWays(int steps) {
        return dynamicHelper(steps, new int[steps+1]);
    }

    int dynamicHelper(int steps, int[] memo){
        if (steps == 0) { return 1; }
        if (steps < 0) { return 0; }

        if (memo[steps] == 0) {
            memo[steps] = dynamicHelper(steps-3, memo) +
                    dynamicHelper(steps-2, memo) + dynamicHelper(steps-1, memo);
        }
        return memo[steps];
    }
}
