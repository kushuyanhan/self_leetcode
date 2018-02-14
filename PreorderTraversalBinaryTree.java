/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author xuemaomao
 *
 */
public class PreorderTraversalBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(5);
		System.out.println(preorderTraversalBinaryTree(root));
	}
	
	public static ArrayList<Integer> preorderTraversalBinaryTree(TreeNode head) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> res = new ArrayList<>();
		if (head == null) {
			return res;
		}
		stack.push(head);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return res;
	}
}
