package 알고리즘인터뷰;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","");
        System.out.println(s);
        String str = s.toLowerCase();
        System.out.println(str);
        for(int i = 0 ; i< str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125 v = new ValidPalindrome125();
        boolean a = v.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(a);
    }
}
