/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
*/

//Recursive Solution gives TLE
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        return countPaths(0,0,n,m,obstacleGrid);
    }
    
    private int countPaths(int i, int j, int n, int m, int[][] obstacleGrid)
    {   
        if(i >= n || j >= m || obstacleGrid[i][j] == 1)
        {
            return 0;
        }
        
        if(i == n -1 && j == m - 1)
        {
            return 1;
        }
        
        return countPaths(i + 1, j, n, m, obstacleGrid) + countPaths(i, j + 1, n, m, obstacleGrid);
    }
}
