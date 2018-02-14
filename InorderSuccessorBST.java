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

public class InorderSuccessorBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(5);
		System.out.println(inorderSuccessorBST(root, node1).val);
	}
	
	public static TreeNode inorderSuccessorBST(TreeNode head, TreeNode p) {
		if (head == null || p == null) {
			return null;
		}
		TreeNode res = null;
		while (head != null) {
			if (p.val < head.val) {
				res = head;
				head = head.left;
			} else {
				head = head.right;
			}
		}
		return res;
	}
}
