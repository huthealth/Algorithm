package Etc;

import java.util.*;

/*
class 호텔방배정 {
    public Map<Long,Long> reservation = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for(int i =0;i<room_number.length;i++){
            if(reservation.containsKey(room_number[i])){
                answer[i] = find(room_number[i]);
            }
            else {
                reservation.put(room_number[i], room_number[i]+1);
                answer[i] = room_number[i];
            }
        }
        return answer;
    }

    public long find(long p){

        long root = p;
        while(reservation.get(root) != null && root != reservation.get(root)) root = reservation.get(root);
        reservation.put(root,root+1);
        while(root+1 != p){
            long next = reservation.get(p);
            reservation.put(p,root+1);
            p = next;
        }
        return root;
    }
}

 */

public class 호텔방배정 {
    private static Map<Long,Long> hotel = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        int people = room_number.length;
        long[] answer = new long[people];
        for(int i = 0; i< people;i++) {
            Long roomKey = hotel.get(room_number[i]);
            if(roomKey == null) {
                answer[i] = room_number[i];
                unify(room_number[i],room_number[i] + 1);
            }
            else {
                long next = find(roomKey);
                answer[i] = next;
                unify(next,next+1);
            }
        }
        return answer;
    }

    private long find(long p) {
        if(hotel.get(p) == null) {
            hotel.put(p,p);
            return p;
        }
        long root = p;
        while(root != hotel.get(root)) root = hotel.get(root);
        while(root != p) {
            long next = hotel.get(p);
            hotel.put(p,root);
            p = next;
        }
        return root;
    }

    private void unify(long p, long q) {
        long rootP = find(p);
        long rootQ = find(q);
        if(rootP == rootQ) return;
        if(rootP < rootQ) hotel.put(rootP,rootQ);
        else hotel.put(rootQ,rootP);
    }

}