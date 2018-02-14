/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author xuemaomao
 * iterative inorder traversal
 */
public class InorderTraversalBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(5);
		System.out.println(inorderTraversalBinaryTree(root));
	}
	
	public static ArrayList<Integer> inorderTraversalBinaryTree(TreeNode head) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> res = new ArrayList<>();
		if (head == null) {
			return res;
		}
		while (head != null || !stack.isEmpty()) {
			while (head != null) {
				stack.add(head);
				head = head.left;
			}
			head = stack.pop();
			res.add(head.val);
			head = head.right;
		}
		return res;
	}
}
