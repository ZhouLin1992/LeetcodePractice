public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		levelOrder(res, root, 0);
		return res;
	}

	public void levelOrder(List<List<Integer>> res, TreeNode root, int height) {
		if (root == null) {
			return;
		}
		if (height >= res.size()) {
			res.add(new ArrayList<Integer>());
		}
		res.get(height).add(root.val);
		levelOrder(res, root.left, height + 1);
		levelOrder(res, root.right, height + 1);
	}
}