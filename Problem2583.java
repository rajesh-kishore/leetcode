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

        PriorityQueue<Long> minHeap = new PriorityQueue<>( (x, y) -> Long.compare(x,y));

        inorderTraversal(root, minHeap, k);


        if (k == minHeap.size()) {
            return minHeap.poll(); // top most one is kth largest
        }

        return -1l;
        
    }

    void inorderTraversal(TreeNode root, PriorityQueue<Long> minHeap, int k) {

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
            
           /*
k = 3
                
                4
                5
                6


           */


            if (k < minHeap.size() + 1) { // if k elements filled
                if (minHeap.peek() < currentLevelSum) { // check topmost one is smaller
                    minHeap.poll(); // remove and get new one
                    minHeap.add(currentLevelSum);
                }
            } else {
                minHeap.add(currentLevelSum); // keep filling till we attain kth element

            }   
              
           }

    }
}
