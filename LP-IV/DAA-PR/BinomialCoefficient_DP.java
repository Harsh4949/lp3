public class BinomialCoefficient_DP {

    // Time Complexity: O(n * k)   // n = row limit, k = chosen value limit
    // Space Complexity: O(n * k)
    public static int binomialCoefficient(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            if (i <= k) {
                dp[i][i] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        System.out.println("C(" + n + ", " + k + ") = " + binomialCoefficient(n, k));
    }
}

// C(n, k) = n! / (k! * (n - k)!)
