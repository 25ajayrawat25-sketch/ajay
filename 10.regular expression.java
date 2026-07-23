class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] represents if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches empty pattern
        dp[0][0] = true;

        // Base cases for patterns like a*, a*b*, a*b*c* matching an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pChar = p.charAt(j - 1);
                char sChar = s.charAt(i - 1);

                if (pChar == '*') {
                    // Option 1: Treat '*' as 0 occurrences of preceding character
                    dp[i][j] = dp[i][j - 2];

                    // Option 2: Treat '*' as 1 or more occurrences (if preceding character matches sChar)
                    char pPrevChar = p.charAt(j - 2);
                    if (pPrevChar == '.' || pPrevChar == sChar) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (pChar == '.' || pChar == sChar) {
                    // Exact character match or '.' wildcard match
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
