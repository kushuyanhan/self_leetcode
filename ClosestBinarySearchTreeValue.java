/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class ClosestBinarySearchTreeValue {
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
	public static int closestValue(TreeNode root, double target) {
		int res = root.val;
		while (root != null) {
			if (Math.abs(target - root.val) < Math.abs(target - res)) {
				res = root.val;
			}
			root = target < root.val ? root.left : root.right;
		}
		return res;
	}
}
//time: O(n), space: O(1)
