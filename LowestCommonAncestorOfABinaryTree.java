/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class LowestCommonAncestorOfABinaryTree {
	public static void main(String[] args) {
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
		node4.left = node5;
		node2.left = node6;
		node2.right = node7;
		
		System.out.println(lca(root, node4, node7).val);
	}
	
	public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
}
//time: O(n), space: O(n)
////https://www.youtube.com/watch?v=13m9ZCB8gjw&t=49s
