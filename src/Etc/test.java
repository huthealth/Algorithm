package Etc;

public class test {





    public static void main(String... args){
        Integer i = 10000;
        String s = "a";
        String s1 = "abcd";
        System.out.println(i.hashCode()-'a');
        System.out.println(s.hashCode()-'a');
        System.out.println(s1.hashCode());
    }
}
