/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(root, sb, true);
        return sb.toString();
    }


    private void traversePreOrder(TreeNode root, StringBuilder sb, boolean isFirst) {
            
            
            if (Objects.isNull(root)) {
                return;
            }
 
            if (!isFirst) {
                sb.append("-");
            }

            sb.append("" + root.val);
            traversePreOrder(root.left, sb, false);
            traversePreOrder(root.right, sb, false);

            //40-30-25-35
    }




    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return formTree( (Objects.isNull(data) || "".equals(data)) ? null :  data.split("-"), new AtomicInteger(-1), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


  // 2
    private TreeNode formTree(String[] arr, AtomicInteger startIndex,int lowerLimit, int upperLimit) {
            // 2,1,3

            TreeNode root = null;

           if (Objects.isNull(arr)) {
               return null;
           }
 
            if (startIndex.get() + 1 >= arr.length) {
                return null;
            }

            startIndex.incrementAndGet();  
            
            String node = arr[startIndex.get()];

            int currentNodeVal = Integer.valueOf(node);

            if (currentNodeVal > lowerLimit && currentNodeVal < upperLimit) { //should be within limit to form a BST
                root = new TreeNode(currentNodeVal);
            } else {
                 startIndex.decrementAndGet();
                 return null; 
            }

            root.left  = formTree(arr, startIndex, lowerLimit, root.val); // left child should be smaller than current one
            root.right = formTree(arr, startIndex, root.val, upperLimit); // upper child must be greater than current one but smaller than upperLimit

            return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
