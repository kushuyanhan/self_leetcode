/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author xuemaomao
 *
 */
public class KthSmallestElementInBST {
	public static void main(String[] args) {
		System.out.println();
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node5.left = node6;
		node5.right = node7;
		int k = 3;
		System.out.println(kthSmallest(root, k));
	}
	//method1 recursion inorder traversal
	private static int count = 0;
	private static int res = 0;
	public static int kthSmallest(TreeNode root, int k) {
		int count = k;
		helper(root);
		return res;
	}
	private static void helper(TreeNode root) {
		if (root == null) return;
		helper(root.left);
		count--;
		if(count == 0) {
			res = root.val;
		}
		helper(root.right);
	}
	//method2 iterative inorder traversal
	public static int kthSmallest(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			stack.push(cur);
		}
		return count;
	}
}
