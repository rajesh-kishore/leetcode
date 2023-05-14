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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {


        List<TreeNode> results = new LinkedList<>();
         traversePreOrder(root, new HashMap<>(), results);
         return results;
    }


    private String traversePreOrder(TreeNode root, Map<String, Integer> calculatedPath, List<TreeNode> results) {
            if (Objects.isNull(root)) {
                return "";
            }

            String left = traversePreOrder(root.left,  calculatedPath, results);
            String right = traversePreOrder(root.right, calculatedPath, results);

            String result = ""+ root.val+ "*"+ left+ "*"+ right; // frame the result
            
            // if after deserialzing the root node, if we get same node again , then thats the common structure
            if (calculatedPath.getOrDefault(result, 0) == 1) { // add only if nots added to result
                results.add(root); 
            }

            calculatedPath.put(result , calculatedPath.getOrDefault(result , 0) + 1); // capture from a specific node - root

            return result;

    }
}
