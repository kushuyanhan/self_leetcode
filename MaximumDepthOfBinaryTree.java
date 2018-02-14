/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */

    
public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		System.out.println(maxDepth(root));
	}
	
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
