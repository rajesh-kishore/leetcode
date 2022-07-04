/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, "", 0);
    }
    
    
    private int sumNumbers(TreeNode root, String numberSoFar, int sumSoFar) {
     
        if (Objects.isNull(root)) {
            return 0;
        }
        
        if (Objects.isNull(root.left) && Objects.isNull(root.right) ) {
            return sumSoFar + Integer.valueOf(numberSoFar  + root.val) ;
        }
        
        
        int leftSum = sumNumbers(root.left, numberSoFar  + root.val, sumSoFar);
        
        int rightSum = sumNumbers(root.right, numberSoFar + root.val, sumSoFar);
        
        
        return sumSoFar + leftSum + rightSum;
        
    }
    
    
}
