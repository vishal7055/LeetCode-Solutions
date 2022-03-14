//Memoized Version
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                dp[i][j] = -1;
            }
        }
        return countPaths(0, 0, n, m, obstacleGrid, dp);
    }
    
    private int countPaths(int i, int j, int n, int m, int[][] obstacleGrid, int[][] dp)
    {   
        if(i >= n || j >= m || obstacleGrid[i][j] == 1)
        {
            return 0;
        }
        
        if(i == n -1 && j == m - 1)
        {
            return 1;
        }
        
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        
        return dp[i][j] = countPaths(i + 1, j, n, m, obstacleGrid, dp) + countPaths(i, j + 1, n, m, obstacleGrid, dp);
    }
}
