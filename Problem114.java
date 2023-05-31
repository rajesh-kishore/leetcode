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
    public void flatten(TreeNode root) {
        flattenMe(root);
    }


    private TreeNode flattenMe(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }

        TreeNode right = flattenMe(root.right); // first flatten rigt nodes

        TreeNode left = flattenMe(root.left);


        root.left = null;

        if (left != null) {
            root.right = left; // link the left flattened subtree first

            while (left.right != null) { // find out right most of left subtree
                left = left.right;
            }

            left.right = right; // link the right most of left tree to right flattend tree
        } else {
            root.right = right;
        }

        return root;

    }
}
