/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

/**
 * @author xuemaomao
 *
 */
public class LevelOrderTraversalofBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(5);
		System.out.println(levelOrderTraversalBinaryTree2(root));
	}
	//bfs
	public static List<List<Integer>>levelOrderTraversalBinaryTree(TreeNode head) {
		List<List<Integer>> res = new ArrayList<>();
		if (head == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(head);
		
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				list.add(node.val);
			}
			res.add(list);
		}
		return res;
	}
	//method2 dfs
	public static List<List<Integer>>levelOrderTraversalBinaryTree2(TreeNode head) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, head, 0);
		return res;
	}
	private static void helper(List<List<Integer>> res, TreeNode root, int height) {
		if (root == null) return;
		if (height >= res.size()) {
			res.add(new ArrayList<Integer>());
		}
		res.get(height).add(root.val);
		helper(res, root.left, height + 1);
		helper(res, root.right, height + 1);
	}
}
