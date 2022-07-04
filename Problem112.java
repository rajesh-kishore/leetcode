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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
       return hasPathSum(root, targetSum, 0);
    }
    
    
     private boolean  hasPathSum(TreeNode root, int targetSum, int sumSoFar) {
        
         if (Objects.isNull(root)) {
            return false;    
         }
         
         if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
             return root.val + sumSoFar == targetSum;
         }
         
         
         if (hasPathSum(root.left, targetSum, sumSoFar + root.val)) {
             return true;
         }
         
         if (hasPathSum(root.right, targetSum, sumSoFar + root.val)) {
             return true;
         }
        
         return false;

    }
}
