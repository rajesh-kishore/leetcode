class Solution {
    public int uniquePaths(int m, int n) {
        
       int path[][] = new int[m][n];



        /*
            start from bottom most 
            start filling last row first
            start filling second last row then
            .....
            first row at last

            so every row will be able to evaulate because previous row
            is already calculated
        */
        for (int i = m - 1 ; i >= 0 ; i--) {
            for (int j = n -1 ; j >= 0 ; j--) { // start from bottom most
                if (i == m - 1 && j == n-1) { // at bottom most
                    path[i][j] = 1; // only one move
                } else if (i == m - 1) {
                    path[i][j] = path[i][j+1]; // we can move only right
                } else if (j == n - 1) {
                    path[i][j] = path[i+1][j]; // we can move only down
                } else {
                    path[i][j] = path[i+1][j] + path[i][j+1];
                }
            }
        }

        return path[0][0];
    }
}
