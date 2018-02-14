/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class BinaryTreeLongestConsecutiveSequence {
	public static void main(String[] args) {
		System.out.println();
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		root.left = node1;
		root.right = new TreeNode(3);
		node1.left = new TreeNode(3);
		node1.right = new TreeNode(5);
		System.out.println(longestConsecutive(root));
	}
	static int res = 0;
	public static int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root, 0, root.val);
		return res;
	}
	private static void helper(TreeNode root, int cur, int target) {
		if (root == null) {
			return;
		}
		if (root.val == target) {
			cur++;
		} else {
			cur = 1;
		}
		res = Math.max(res, cur);
		helper(root.left, cur, root.val + 1);
		helper(root.right, cur, root.val + 1);
	}
	
}
