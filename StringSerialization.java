package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringSerialization {
	public static void main(String[] args) {
		//String str = "lintcode";
		List<String> list = new ArrayList<>();
		list.add("lint");
		list.add("code");
		String encoded = encode(list);
		List<String> res = decode(encoded);
		System.out.println(res);;
	}
	public static String encode(List<String> strs) {
        // write your code here
        StringBuilder result = new StringBuilder();
        for(String str : strs){
            result.append(String.valueOf(str.length()) + "$");
            result.append(str);
        }
        return result.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        // write your code here
         List<String> result = new LinkedList<String>();
        int start = 0;
        while(start < str.length()){
            int idx = str.indexOf('$', start);
            int size = Integer.parseInt(str.substring(start, idx));
            result.add(str.substring(idx + 1, idx + size + 1));
            start = idx + size + 1;
        }
        return result;
    }

}
