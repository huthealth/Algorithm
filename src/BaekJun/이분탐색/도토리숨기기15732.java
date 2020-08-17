package BaekJun.이분탐색;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class 도토리숨기기15732 {
    private static class Rule {
        int start;
        int end;
        int dif;
        public Rule(int s, int e, int d) {
            start = s;
            end = e;
            dif = d;
        }
    }
    public static void main(String... args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        int D = Integer.parseInt(inputs[2]);

        Rule[] rules = new Rule[K];
        int lo = Integer.MAX_VALUE ;
        for(int i =0; i<K; i++){
            inputs = br.readLine().split(" ");
            if(lo > Integer.parseInt(inputs[0])) lo = Integer.parseInt(inputs[0]);
            rules[i] = new Rule(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2]));
        }

        int hi = lo + N -1;
        int mid = (lo + hi) / 2; // 박스 번호
        int lastBox = 0;
        while(lo <= hi){
            long count = 0;
            for(int i = 0 ;i<K; i++) {
                int start = rules[i].start;
                int end = rules[i].end;
                int dif = rules[i].dif;
                int endOrMid = Math.min(end,mid);
                endOrMid -= start;
                if(endOrMid < 0) continue;
                count = count + (endOrMid / dif ) + 1;
                /*
                if(start <= mid) count++;

                while(start + dif <= mid && start + dif <= end ) {
                    start += dif;
                    count++;
                }

                 */
            }

            if(count >= D) {
                lastBox = mid;
                hi = mid -1;
            }
            else {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }
        System.out.println(lastBox);
    }
}
