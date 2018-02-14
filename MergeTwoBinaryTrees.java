/**
 * 
 */
package leetcode;

import java.util.ArrayList;

/**
 * @author xuemaomao
 *
 */
public class MergeTwoBinaryTrees {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
		node1.right = node3;
		
		node4.left = node5;
		node4.right = node6;
				
		TreeNode root = mergeTrees(node1, node4);
		
		//print merged tree in preorder traversal
	    helper(root);
	} 
	private static void helper(TreeNode root) {
	    if (root == null) {
	        return;
	    }
	    System.out.println(root.val);
	    helper(root.left);
	    helper(root.right);
	 }
	 public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		 if (t1 == null) {
			 return t2;
		 }
		 if (t2 == null) {
			 return t1;
		 }
		 TreeNode newNode = new TreeNode(t1.val + t2.val);
		 newNode.left = mergeTrees(t1.left, t2.left);
		 newNode.right = mergeTrees(t1.right, t2.right);
		 return newNode;
	 }
}	
//time: O(n), space: O(n)
//binary tree 递归写法比较不好想，如果细节，容易晕倒， 从函数的定义上去理解，mergeTrees(root1, root2) 
//是merge root1, root2 的节点值之和作为新的root.返回这个root