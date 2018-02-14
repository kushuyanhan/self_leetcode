/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class SameTree {
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
		node5.left = node6;
		node5.right = node7;
		
		System.out.println(isSameTree(root, node5));
	}
	
	public static boolean isSameTree(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	}
}
//time: O(n), space; O(h)
