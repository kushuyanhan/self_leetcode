package leetcode;

public class DetectCapital {
	public static void main(String[] args) {
		System.out.println(detectCapitalUse("FlaG"));
	}
	
	public static boolean detectCapitalUse(String word) {
		int upperCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCount++;
            }
        }
        if (upperCount == 1) {
            return Character.isUpperCase(word.charAt(0));
        }
        return upperCount == word.length() || upperCount == 0;
	}
}
//time: O(n), space: O(1)