package leetcode;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome2(123));
	}
	public static boolean isPalindrome(int x) {
		long res = 0;
        int origin = x;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}
		return (int)res == origin;
	}
	//method2
	public static boolean isPalindrome2(int x) {
		if (x < 0 || (x!= 0 && x % 10 == 0)) { //10 is not
			return false;
		}
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x /= 10;
		}
		return rev == x || rev / 10 == x;
	}
}
//time: O(n), space: O(1) 这个在leetcode 可以过，但是这个解法不包含越界的情况，reverse 以后可能会越界
//更加generic is method2, 
//reverse 一半， 然后和前半部分比较，是否一致，或者/10相等，因为有奇数位和偶数位2种情况。
//121, rev=12, x=1

