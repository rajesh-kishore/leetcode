class Solution {
    public int numEnclaves(int[][] grid) {
        
        // exclude which are reachable from boundary
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {

                if (grid[i][j] == 1 && (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1)) {
                    markAllReachableFromBoundary(grid, i, j);
                }
                
            }    
        }
        
        // now count which are not reachable from boundary land cells
        int count = 0;
        for (int i = 1 ; i < grid.length - 1; i++) {
            for (int j = 1 ; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 1) {
                    count += navigateAndCountConnectedComponents(grid, i, j);
                }
                
            }    
        }
        return count;
    }
    
    private void markAllReachableFromBoundary(int[][] grid, int i , int j) {
    
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
            return;
        }
        
        grid[i][j] = 0; // mark it 
        
        markAllReachableFromBoundary(grid, i + 1, j);
        markAllReachableFromBoundary(grid, i - 1, j);
        markAllReachableFromBoundary(grid, i, j + 1);
        markAllReachableFromBoundary(grid, i, j - 1);
    }
    
    
     private int navigateAndCountConnectedComponents(int[][] grid, int i , int j) {
    
        int count = 0;
         
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
            return count;
        }
        
        grid[i][j] = 0; // mark it 
         
        count++;
         
        count += navigateAndCountConnectedComponents(grid, i + 1, j);
        count += navigateAndCountConnectedComponents(grid, i - 1, j);
        count += navigateAndCountConnectedComponents(grid, i, j + 1);
        count += navigateAndCountConnectedComponents(grid, i, j - 1);
         
         return count;
    }
    
    
}
