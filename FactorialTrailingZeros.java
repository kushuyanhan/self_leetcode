package leetcode;

public class FactorialTrailingZeros {
	public static void main(String[] args) {
		int n = 10;
		factor(n);
		System.out.println(factor(n));
	}
	public static int factor(int n) {
		int res = 0;
	    while (n > 0) {
	        res += n / 5;
	        n /= 5;
	    }
	    return res;
	}
	
}
