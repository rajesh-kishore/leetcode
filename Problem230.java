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
    
    
    
    public int kthSmallest(TreeNode root, int k) {
     
            // start with root as level 0
            return kthSmallest(root, k, new AtomicInteger(0)); 
    }
    
    
    
     public int kthSmallest(TreeNode root, int k, AtomicInteger currentLevel) {
     
          if (Objects.isNull(root)) {
              return -1;
          }
        
         // keep traversing till left as the left most child in BST is smallest
          int left = kthSmallest(root.left, k, currentLevel);
         
           if (left != -1) { // if you got your result then terminate from here
               return left;
           }

          currentLevel.getAndIncrement(); // increment current level
         
          if (k == currentLevel.get()) {
              return root.val;
          }
        
          int right = kthSmallest(root.right, k, currentLevel); 
           
          if (right != -1) { // if you got your result then terminate from here
               return right;
          }

          return -1;
    }
}
