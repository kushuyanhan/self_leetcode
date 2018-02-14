package leetcode;

public class MinimumAbsoluteDifferenceInBST {
	 public static void main(String[] args) {	
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		root.left = node1;
		root.right = new TreeNode(9);
		int res = getMinimumDifference(root);
		System.out.println(res);
	}
	 
	static int min = Integer.MAX_VALUE;
    static Integer prev = null;

    public static int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
}
