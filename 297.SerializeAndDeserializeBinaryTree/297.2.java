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
        return serialize(root, new StringBuilder()).toString();
    }

    private StringBuilder serialize(TreeNode root, StringBuilder values) {
    	if (root == null) {
    		values.append("null,");
    	} else {
    		values.append(root.val).append(",");
    		values = serialize(root.left, values);
    		values = serialize(root.right, values);
    	}

    	return values;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        List<String> valueList = new ArrayList<>(Arrays.asList(values));
        return deserialize(valueList);
    }

    private TreeNode deserialize(List<String> valueList) {
    	if (valueList.get(0).equals("null")) {
    		valueList.remove(0);
    		return null;
    	}

    	TreeNode root = new TreeNode(Integer.parseInt(valueList.get(0)));
    	valueList.remove(0);
    	root.left = deserialize(valueList);
    	root.right = deserialize(valueList);

    	return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));