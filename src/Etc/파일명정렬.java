package Etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 파일명정렬 {
    private class Entity{
        String head;
        Integer num;
        Integer index;
        public Entity(String head,Integer num, Integer index){
            this.head  = head;
            this.num = num;
            this.index = index;
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<Entity> list = new ArrayList<>();

        for(int i =0;i<files.length;i++){
            String head,num;
            int idx =0;
            for(int j =0;j<files[i].length();j++){
                if(!Character.isDigit(files[i].charAt(j))) idx++;
                else break;
            }

            head = files[i].substring(0,idx);
            int idx2 = idx;
            for(int j =idx2;j<files[i].length();j++){
                if(Character.isDigit(files[i].charAt(j))) idx2++;
                else break;
            }
            num = files[i].substring(idx,idx2);
            list.add(new Entity(head.toLowerCase(),Integer.parseInt(num),i));
        }
        Collections.sort(list, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                if (o1.head.equals(o2.head)) {
                    if (o1.num.equals(o2.num)) return o1.index.compareTo(o2.index);
                    return o1.num.compareTo(o2.num);
                }
                return o1.head.compareTo(o2.head);
            }
        });
        for(int i =0;i<files.length;i++){
            answer[i] = files[list.get(i).index];
        }
        return answer;
    }
    public static void main(String... args){
        파일명정렬 a = new 파일명정렬();
        String[] s = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String s2 = "img12.png imgaa.jpg    imp.kk";
        String[] ss = s2.split("\\s");
        System.out.println(ss.length);
        for(String temp : ss) System.out.println(temp);
        //System.out.println(s2.toLowerCase());
       // System.out.println(a.solution(s));
    }
}