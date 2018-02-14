/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuemaomao
 *
 */
public class InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(5);
		System.out.println(invertTree(root));
	}
	//method1 dfs
	 public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right= invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
	 }
	 
	 //method2 bfs
	 public static TreeNode invertTree2(TreeNode root) {
		 if (root == null) return root;
		 Queue<TreeNode> queue = new LinkedList<>();
		 queue.offer(root);
		 while (!queue.isEmpty()) {
			 int size = queue.size();
			 for (int i = 0; i < size; i++) {
				 TreeNode cur = queue.poll();
				 TreeNode temp = cur.left;
				 cur.left = cur.right;
				 cur.right = temp;
				 if (cur.left != null) {
					 queue.offer(cur.left);
				 }
				 if (cur.right != null) {
					 queue.offer(cur.right);
				 }
			 }
		 }
		return root;
	 }
}
//time: O(n), space: O(n) due to recurion, O(n) due to queue
