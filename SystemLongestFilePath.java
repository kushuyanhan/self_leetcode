package leetcode;

public class SystemLongestFilePath {
	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(lengthLongestPath(input));
	}
	public static int lengthLongestPath(String input) {
        // write your code here
        if (input.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] level_size = new int[input.length() + 1];

        for (String line : input.split("\n")) {
            int level = line.lastIndexOf('\t') + 2;
            int len = line.length() - (level - 1);
            if (line.contains(".")) {
                ans = Math.max(ans, level_size[level - 1] + len);
            } else {
                level_size[level] = level_size[level - 1] + len + 1;
            }
        }
        return ans;
    }
}
