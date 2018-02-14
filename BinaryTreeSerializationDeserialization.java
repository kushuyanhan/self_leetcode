/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuemaomao
 *
 */
public class BinaryTreeSerializationDeserialization {
	public static void main(String[] args) {
		System.out.println();
		System.out.println();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		node1.left = new TreeNode(0);
		node1.right = new TreeNode(2);
		System.out.println(encode(root));
		System.out.println(decode(encode(root)).val);
		System.out.println(encode2(root));
		System.out.println(decode2(encode(root)).val);
	}
	
	//method1 iterative, bfs, level order traversal,  1 2 3 null null 4 5
	public static String encode(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				sb.append(null + " ");
				continue;
			}
			sb.append(cur.val + " ");
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		return sb.toString();
	}
	
	public static TreeNode decode(String s) {
		String[] str = s.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		for (int i = 1; i < str.length; i++) {
			TreeNode cur = queue.poll();
			if (!str[i].equals("null")) {
				cur.left = new TreeNode(Integer.parseInt(str[i]));
				queue.offer(cur.left);
			}
			if (!str[++i].equals("null")) {
				cur.right = new TreeNode(Integer.parseInt(str[i]));
				queue.offer(cur.right);
			}
		}
		return root;
	}
	
	//method2 recursive dfs
	//preorder traversal, use queue to store the nodes
	public static String encode2(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		builderString(root, sb);
		return sb.toString();	
	}
	//preorder traversal result
	private static void builderString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null").append(" ");
		} else {
			sb.append(root.val).append(" ");
			builderString(root.left, sb);
			builderString(root.right, sb);
		}
	}
	
	public static TreeNode decode2(String s) {
		Queue<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(s.split(" ")));
		return buildTree(nodes);
	}
	private static TreeNode buildTree(Queue<String> nodes) {
		String val = nodes.poll();
		if (val.equals("null")) {
			return null;
		} else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}
}
