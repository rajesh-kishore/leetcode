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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
 
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        
        if (Objects.isNull(root)) {
            return results;
        }

        Stack<TreeNode> parent = new Stack<>(); // need stack as we grow deep down and we have to extract LIFO

        parent.push(root);
        boolean fromLeftToRight = true;
        
        while (!parent.isEmpty()) {
         
            List<Integer> res = new LinkedList<>();
            results.add(res);
            
            Stack<TreeNode> child = new Stack<>(); // need another stack to put next level info
            while (!parent.isEmpty()) { // empty current parent i.e traverse all nodes in current level 
                TreeNode top = parent.pop();
                res.add(top.val);
                if (fromLeftToRight) {
                   if (Objects.nonNull(top.left)) {
                       child.push(top.left); // left to push first so that its extracted later
                   } 
                   if (Objects.nonNull(top.right)) {
                        child.push(top.right);  
                   }   
                 
                } else {
                    if (Objects.nonNull(top.right)) {
                        child.push(top.right);  // right to push first so that its extracted later
                    }    
                   
                    if (Objects.nonNull(top.left)) {
                        child.push(top.left);
                    }
                     
                }
            }
            
            fromLeftToRight = !fromLeftToRight;
            
            parent = child;
            
        }
        
        return results;
        
    }
}
