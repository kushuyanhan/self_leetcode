/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class ClosestBinarySearchTreeValueii {
	public static void main(String[] args) {
		System.out.println();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		node1.left = new TreeNode(0);
		node1.right = new TreeNode(2);
		System.out.println(closestValue(root, 2.6));
	}

	/**
	 * @param root
	 * @param d
	 * @return
	 */
	private static char[] closestValue(TreeNode root, double d) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
