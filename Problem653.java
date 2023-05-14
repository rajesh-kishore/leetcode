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
    public boolean findTarget(TreeNode root, int k) {

                /*
                         k = 4
                            2
                         1     3

                */
            return inorderTravsersal(root, new HashSet<>(), k);            
    }


   private boolean inorderTravsersal(TreeNode root, Set<Integer> results, int k) {
                if (Objects.isNull(root)) {
                    return false;
                }
                if (inorderTravsersal(root.left, results, k)) {
                    return true;
                }
                if (results.contains(k - root.val)) { // look for difference if already found during traversal
                    return true;
                }
                results.add(root.val); // this number would be looked up later during minusing with target sum
                if (inorderTravsersal(root.right, results, k)) {
                    return true;
                }
                return false;
    }
}
