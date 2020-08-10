package Etc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KakaoEn5 {
    public static void main(String... args) {
        String str = "catdog is not a hotdog";
        Pattern p = Pattern.compile("[a-z]");
        System.out.println(p.pattern());
        Matcher m = p.matcher(str);
        System.out.println(m.find());

        String str2 = "abcde";
        System.out.println( str2.indexOf("[a-z]"));
    }
}
