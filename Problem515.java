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

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> lst = new LinkedList<>();
        inorderTraversal(root, lst);
        return lst;
    }


    
 

    void inorderTraversal(TreeNode root, List<Integer> lst) {

           Queue<TreeNode> queue = new LinkedList<>();
           if (Objects.nonNull(root)) {
              queue.add(root);
           }

           while (!queue.isEmpty()) {

               int currentLevelSize = queue.size();
               int maxVal = Integer.MIN_VALUE;

               while (currentLevelSize > 0) {
                    
                    TreeNode temp = queue.remove();

                    if (maxVal < temp.val) {
                        maxVal = temp.val;
                    }

                    if (!Objects.isNull(temp.left)) {
                            queue.add(temp.left);
                    }
                    if (!Objects.isNull(temp.right)) {
                            queue.add(temp.right);
                    }
                    currentLevelSize--;
               }

              lst.add(maxVal);
           }

    }
 


}
