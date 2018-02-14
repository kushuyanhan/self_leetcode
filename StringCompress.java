package leetcode;

public class StringCompress {
	public static void main(String[] args) {
		char[] chars = {'a','a','b','b','c','c','c'};
		int res = compress(chars);
		//System.out.println(res);
	}
	public static int compress(char[] chars) {
        int res = 0, index = 0;
        while (index < chars.length) {
            char cur = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == cur) {
                index++;
                count++;
            }
            chars[res++] = cur;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
//        for (char c : chars) {
//        	System.out.println(c);
//        }
        return res;
    }
}
