class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int path[][] = new int[m][n];



        /*
            start from bottom most 
            start filling last row first
            start filling second last row then
            .....
            first row at last

            so every row will be able to evaulate because previous row
            is already calculated

            now with respect to obstacle 
            path[i][j] should be marked 0 when there is a obstacle on that cell - by marking 0 we are saying there is no path exist from that cell
            incase there is no obstacle on that path then find out SUM OF i+1 or j+1 is having any obstacle

        */
        for (int i = m - 1 ; i >= 0 ; i--) {
            for (int j = n -1 ; j >= 0 ; j--) { // start from bottom most
                if (i == m - 1 && j == n-1) { // at bottom most
                    path[i][j] = 1; // only one move
                } else if (i == m - 1) {
                    path[i][j] = obstacleGrid[i][j] != 1 ?  path[i][j+1] : 0; // we can move only right
                } else if (j == n - 1) {
                    path[i][j] = obstacleGrid[i][j] != 1 ?  path[i+1][j] : 0; // we can move only down
                } else {
                    path[i][j] = obstacleGrid[i][j] == 1 ?  0 : 
                    (path[i+1][j]  + path[i][j+1] );
                }
            }
        }

        return path[0][0];

    }
}
