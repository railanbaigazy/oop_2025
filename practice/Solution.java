import java.util.*;

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];

        for (int i = n - 1; i>= 0; i--) {
            long cur = 0;
            int prevIdx = i + questions[i][1] + 1;

            if (prevIdx < n) {
                cur += dp[prevIdx];
            }

            dp[i] = Math.max(dp[i+1], cur);
        }

        return dp[0];
    }
}