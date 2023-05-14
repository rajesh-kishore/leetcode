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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return formTree(data.split(","), new AtomicInteger(-1));
    }


    private void traversePreOrder(TreeNode root, StringBuilder sb, boolean isFirst) {
            
            if (!isFirst) {
                sb.append(","); // only first time escape appending
            }
            
            if (Objects.isNull(root)) { // represent null as #
                    sb.append("#");
                     return;
            }
 

            sb.append("" + root.val);
            traversePreOrder(root.left, sb, false);
            traversePreOrder(root.right, sb, false);

    }

    private TreeNode formTree(String[] arr, AtomicInteger startIndex) {
            
            TreeNode root = null;
            if (arr.length == 0) {
                return root;
            }

            startIndex.incrementAndGet();       
            String node = arr[startIndex.get()];
            if ("#".equals(node)) {
                   return root; // means empty
            }

            root = new TreeNode(Integer.valueOf(node));

            root.left =  formTree( arr, startIndex);
            root.right = formTree(arr, startIndex);

            return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
