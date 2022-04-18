class Solution {
    
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        int m = grid2.length, n = grid2[0].length;
        for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (grid2[i][j] == 1) {
                   // visit ^ identify grid 2 connected island & simulatenaously compare if its valid
                   // in grid1
                   if (visitGrid2ConnectedIsland(grid1, grid2, m, n, i, j, false)) {
                      // do nothing;
                       // means grid2 is not subisland i.e grid2 connected island is more than gridl1 connected island
                   } else {
                       result++;
                   }
               }
           } 
        }
        return result;
    }
    private boolean visitGrid2ConnectedIsland(int[][] grid1, int[][] grid2, int m, int n, int r, int c, boolean hasInvalidCellCount) {
        
        if ((r < 0 || r >= m) || (c < 0 || c >= n) || (grid2[r][c] == 0)) {
            return hasInvalidCellCount;
        }
        
        if (grid2[r][c] == 1 && grid1[r][c] == 0) {
            hasInvalidCellCount = true; // mark it but still continuing marking connected island for grid2
        }
        grid2[r][c] = 0; // mark as visited
        
        hasInvalidCellCount = visitGrid2ConnectedIsland(grid1, grid2, m, n, r - 1, c, hasInvalidCellCount);
        hasInvalidCellCount = visitGrid2ConnectedIsland(grid1, grid2, m, n, r, c + 1, hasInvalidCellCount);
        hasInvalidCellCount = visitGrid2ConnectedIsland(grid1, grid2, m, n, r + 1, c, hasInvalidCellCount);
        hasInvalidCellCount = visitGrid2ConnectedIsland(grid1, grid2, m, n, r, c - 1, hasInvalidCellCount);
       
        return hasInvalidCellCount;
    }
}
