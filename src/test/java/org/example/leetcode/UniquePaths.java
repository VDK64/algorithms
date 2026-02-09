package org.example.leetcode;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = dp[i - 1][j] + dp[i][j - 1];
                if (sum == 0) {
                    sum++;
                }
                dp[i][j] = sum;
            }
        }

        return dp[m][n];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                int vertical = i - 1;
                int horizontal = j - 1;
                if (obstacleGrid[vertical][horizontal] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}