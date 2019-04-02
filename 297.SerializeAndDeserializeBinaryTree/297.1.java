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
        if (root == null) {
        	return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
        	TreeNode curr = queue.get(i);
        	if (curr == null) {
        		continue;
        	}
        	queue.add(curr.left);
        	queue.add(curr.right);
        }

        while (queue.get(queue.size() - 1) == null) {
        	queue.remove(queue.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);

        for (int i = 1; i < queue.size(); i++) {
        	TreeNode curr = queue.get(i);
        	if (curr == null) {
        		sb.append(",#");
        	} else {
        		sb.append(",");
        		sb.append(curr.val);
        	}
        }

        sb.append("}");

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data.equals("{}")) {
    		return null;
    	}

    	String[] values = data.substring(1, data.length() - 1).split(",");
    	ArrayList<TreeNode> queue = new ArrayList<>();
    	TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    	queue.add(root);
    	
    	boolean isLeft = true;
    	int index = 0;
    	for (int i = 1; i < values.length; i++) {
    		TreeNode curr = queue.get(index);
    		if (!values[i].equals("#")) {
    			TreeNode node = new TreeNode(Integer.parseInt(values[i]));
	    		if (isLeft) {
	    			curr.left = node;
	    		} else {
	    			curr.right = node;
	    		}
	    		queue.add(node);
    		}
    		if (!isLeft) {
    			index++;
    		}
    		isLeft = !isLeft;
    	}
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));