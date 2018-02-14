/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuemaomao
 *
 */
public class FindLeavesOfBinaryTree {
	public static void main(String[] args) {
		System.out.println();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		node1.left = new TreeNode(0);
		node1.right = new TreeNode(2);
		//System.out.println(findLeaves(root));
		System.out.println(findLeaves2(root));
	}
	//method1, 根据当前res 里面加的几个list==level, 来判断是否是新的一层。
//	public static List<List<Integer>> findLeaves(TreeNode root) {
//		List<List<Integer>> res = new ArrayList<>();
//		helper(root, res);
//		return res;
//	}
//	private static int helper(TreeNode root, List<List<Integer>> res) {
//		if (root == null) return -1;
//		int left = helper(root.left, res);
//		int right = helper(root.right, res);
//		int level = Math.max(left, right) + 1;
//		if (res.size() == level) {
//			res.add(new ArrayList<>());
//		}
//		res.get(level).add(root.val);
//		root.left = null;//remove leaves 需要这一步，如果不用remove, 只是返回就不用这一步
//		root.right = null;
//		return level;
//	}
	//The height of a node is also the its index in the result list (res). For example, leaves, whose heights are 0, are stored in res[0]. Once we find the height of a node, we can put it directly into the result.
	//method2, 根据当前的节点是否是叶子节点，作为递归的返回条件
	public static List<List<Integer>> findLeaves2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		while (root != null) {
			List<Integer> list = new ArrayList<>();
			if (dfs(root, list)) root = null;
			res.add(list);
		}
		return res;
	}
	private static boolean dfs(TreeNode root, List<Integer> list) {
		if (root == null) return false;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return true;
		}
		if (dfs(root.left, list)) root.left = null;
		if (dfs(root.right, list)) root.right = null;
		return false;
	}
}
