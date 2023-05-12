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
    public long kthLargestLevelSum(TreeNode root, int k) {

        PriorityQueue<Long> maxHeap = new PriorityQueue<>( (x, y) -> Long.compare(y, x));

        inorderTraversal(root, maxHeap);

        int counter = 0;
        while (!maxHeap.isEmpty() && counter < k) {
            long sum = maxHeap.poll();
            counter++;
            if (counter == k) {
                return sum;
            }
        }

        return -1l;
        
    }

    void inorderTraversal(TreeNode root, PriorityQueue<Long> maxHeap) {

           Queue<TreeNode> queue = new LinkedList<>();
           queue.add(root);

           while (!queue.isEmpty()) {

               int currentLevelSize = queue.size();
               long currentLevelSum = 0l;

               while (currentLevelSize > 0) {
                    TreeNode temp = queue.remove();
                    currentLevelSum += temp.val;

                    if (!Objects.isNull(temp.left)) {
                            queue.add(temp.left);
                    }
                    if (!Objects.isNull(temp.right)) {
                            queue.add(temp.right);
                    }
                    currentLevelSize--;
               }

              maxHeap.add(currentLevelSum);
           }

    }
}
