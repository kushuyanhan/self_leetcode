package leetcode;

public class LicenseKeyFormatting {
	public static void main(String[] args) {
		String s = "5F3Z-2e-9-w";
		System.out.println(licenseKeyFormatting(s, 4));
	}
	public static String licenseKeyFormatting(String S, int K) {
//        StringBuilder sb = new StringBuilder();
//        char[] chars = S.toCharArray(); 
//        int cnt = 0;
//        for(int i = S.length() - 1; i >= 0; i--){
//            if (chars[i] == '-') {
//            	continue;
//            }
//            sb.append(chars[i]);
//            if (++cnt % K == 0) {
//            	sb.append("-");
//            }
//        }
//        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
//        	sb.deleteCharAt(sb.length() - 1);
//        }
//        return sb.reverse().toString().toUpperCase();   
		
		//method2
		 StringBuilder sb = new StringBuilder();
		 for (int i = S.length() - 1; i >= 0; i--)
		      if (S.charAt(i) != '-')
		         sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
		 return sb.reverse().toString().toUpperCase();
   }
}
