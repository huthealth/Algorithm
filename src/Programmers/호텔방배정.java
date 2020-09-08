package Programmers;

import java.util.HashMap;
import java.util.Map;

public class 호텔방배정 {
    Map<Long,Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = {};
        answer = new long[room_number.length];
        for(int i = 0 ; i< room_number.length;i++) {
            if(!map.containsKey(room_number[i])) {
                answer[i] = room_number[i];
                map.put(room_number[i],room_number[i]+1);
                continue;
            }
            long room = find(room_number[i]);
            answer[i] = room;
        }
        for(long l : answer) System.out.println(l);
        return answer;
    }

    private long find(long roomNumber) {

        long root = map.get(roomNumber);
        while(true) {
            if(!map.containsKey(root)) break;
            root = map.get(root);
        }
        while(true) {
            if(!map.containsKey(roomNumber)) break;
            long next = map.get(roomNumber);
            map.put(roomNumber,root);
            roomNumber = next;
        }
        map.put(root,root+1);
        return root;
    }

    public static void main(String[] args) {
        호텔방배정 a = new 호텔방배정();

        long[] ary = {1, 3, 4, 1, 3, 1};
        a.solution(10,ary);
    }
}
