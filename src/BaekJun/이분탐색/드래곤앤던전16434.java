package BaekJun.이분탐색;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class 드래곤앤던전16434 {
    private static class Room {
        int t;
        int a;
        int h;
        public Room(int t, int a, int h){
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int heroATK = Integer.parseInt(inputs[1]);
        long lo = 1;
        long hi = 0;
        Room[] rooms = new Room[N];
        for(int i = 0 ; i < N; i++) {
            inputs = br .readLine().split(" ");
            rooms[i]= new Room(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2]));
            if(rooms[i].t == 1){
                int countOfATK = rooms[i].h/ heroATK;
                if(rooms[i].h % heroATK != 0 ) countOfATK++;
                long damage = (long)rooms[i].a * countOfATK;
                hi += damage;
            }
        }

        long mid = (lo + hi) / 2;
        long minHp = 0;

        while(lo <= hi) {
            boolean complete = true;
            long nowHp = mid;
            long nowATK = heroATK;
            for (int i = 0; i < N; i++) {
                if (rooms[i].t == 1) {
                    long countOfATK = (long)rooms[i].h / nowATK;
                    if (rooms[i].h % nowATK == 0) countOfATK--;
                    long damage = (long)rooms[i].a * countOfATK;
                    nowHp -= damage;
                    if(nowHp <= 0) {
                        complete = false;
                        break;
                    }
                } else {
                    nowATK += rooms[i].a;
                    if(nowHp + rooms[i].h > mid) {
                        nowHp = mid;
                    }
                    else {
                        nowHp += rooms[i].h;
                    }
                }
            }
            if(complete) {
                minHp = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;

        }
        System.out.println(minHp);
    }
}
