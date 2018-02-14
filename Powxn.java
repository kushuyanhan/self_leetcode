package leetcode;

public class Powxn {
	public static void main(String[] args) {
		System.out.println(myPow(2, 3));
	}
	//method1 recursion： time: O(logn)
	public static double myPow(double x, int n) {
		if (n < 0) return 1 / power(x, -n);
		return power(x, n);
	}
	public static double power(double x, int n) {
		if (n == 0) return 1;
		double half = power(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		}
		return x * half * half;
	}
	//2^2 = 2^1*2^1 = (2^0 * 2^0 * 2) = (1 * 1 * 2) + (*1 * 1 * 2) = 4
	//method2 iterative time: O(n)
//	public static double myPow(double x, int n) {
//        double res = 1.0;
//        for (int i = n; i != 0; i /= 2) {
//            if (i % 2 != 0) {
//            	res *= x;
//            }
//            x *= x;
//        }
//        return n < 0 ? 1 / res : res;
//    }
}
