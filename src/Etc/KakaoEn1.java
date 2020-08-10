package Etc;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KakaoEn1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int level = 0;
        Pattern p1 = Pattern.compile("[a-z]");
        Pattern p2 = Pattern.compile("[A-Z]");
        Pattern p3 = Pattern.compile("[0-9]");
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m1 = p1.matcher(input);
        Matcher m2 = p2.matcher(input);
        Matcher m3 = p3.matcher(input);
        Matcher m4 = p4.matcher(input);

        if(input.length() >= 10) level++;
        if(m1.find()) level++;
        if(m2.find()) level++;
        if(m3.find()) level++;
        if(m4.find()) level++;
        System.out.println(level);
    }
}
