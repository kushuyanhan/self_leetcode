package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestAbsoluteFilePath {
	public static void main(String[] args) {
		String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(lengthLongestPath(s));
	}
	
	public static int lengthLongestPath(String input) {
		int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 2; //dir 算第一层， 第一层没有\t
            int len = s.length() - (level - 1);// remove the first \t, 几个level 就有几个\t, 
            if (s.contains(".")) {
                res = Math.max(res, m.get(level - 1) + len);
            } else {
                m.put(level, m.get(level- 1) + len + 1);
            }
        }
        return res;
    }
}
////time: O(n) space: O(n) due to stack
//过getline函数可以一行一行的获取数据，实际上相当于根据回车符\n把每段分割开了，
//然后对于每一行，我们找最后一个空格符\t的位置，然后可以得到文件或文件夹的名字，
//然后我们判断其是文件还是文件夹，如果是文件就更新res，如果是文件夹就更新哈希表的映射，
//