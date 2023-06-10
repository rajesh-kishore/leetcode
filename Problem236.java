/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(
        TreeNode root, TreeNode p, TreeNode q) {

      if (root == null) {
          return root;
      }

      if (p == root) {
          // same node found
          return root;
      }

      if (q == root) {
          // same node found
          return root;
      }

     
     TreeNode left = lowestCommonAncestor(root.left, p , q);

     TreeNode right = lowestCommonAncestor(root.right, p , q);

      if (left != null && right != null) {
          return root; // means we have common parent as current root
      }

        if (left != null) {
            // means we got the common root as left
            // assuming other node must be some child of left
            return left;
        }

    if (right != null) {
            // means we got the common root as right
            return right;
        }

        return null;// no common node found


    }
}
