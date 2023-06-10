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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return null;
        }

        if (root == p) {
            return p;
        }

        if (root == q) {
            return q;
        }

        TreeNode left = null;

        if (p.val <= root.val || q.val <= root.val) {// no point in looking left child if value is not smaller
            left = lowestCommonAncestor(root.left, p, q);
        }

        TreeNode right = null;

        if (p.val >= root.val || q.val >= root.val) {// no point in looking right child if value is not greater
            right = lowestCommonAncestor(root.right, p, q);
        }

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }


        if (right != null) {
            return right;
        }

        return null;




    }
}
