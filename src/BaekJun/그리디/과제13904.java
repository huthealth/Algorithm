/*
방법 1 :
뒤에서 부터 계산
최대힙 사용
N일까지 할 수 있는 숙제가 최대로 기간이 긴 숙제라면
N부터 1일까지 for문을 돌며 현재날짜와 같은 과제들을 전체 과제에서 검색해 최대힙에 추가
제일 큰 점수 최대 힙에서 꺼내 정답에 추가

시간 복잡도 : N^2logN이지만 중간마다 줄여주는 부분있고 N이 최대 10^3이여서 시간내에 합격
N이 커지면 사용할 수 없는 방법이여서 다른 방법을 찾아봤다.

방법 2 :
최소힙 사용
1일부터 N일 까지 , 작은 score부터 큰 score로 정렬시킴
work가 들어있는 배열을 처읍부터 끝까지 검색
최소힙의 크기가 현재 날짜까지 해결한 과제 수를 뜻함
배열에서 선택된 work의 day가 과제 수(pq의 크기)보다 크다면 최소힙에 추가
(지금 day가 3인데 pq가 1이면 3일동안 1개의 과제만 해결한 것이므로 무조건 선택된 과제 할 수 있음)
day와 과제 수가 같고( + 작거나 이지만 작은 경우 x) 최소힙의 top값보다 work의 score가 더 크다면 poll 후 add
(현재 day가 3인데 pq크기가 3이라면 3일동안 3개의 과제를 한 경우이므로 더 할 수 없다.
현재 비교하는 과제의 score가 최소힙의 top 값보다 크다면 교환하는 것이 이득이므로 교환 )
N까지 반복하면 pq안의 전체 값들이 최종일까지 할 수 있는 과제들의 최대 값들


 */

package BaekJun.그리디;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Comparator;
        import java.util.PriorityQueue;

public class 과제13904 {

    public static class Work {
        Integer day;
        Integer score;

        Work(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Work[] ary = new Work[N];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int day = Integer.parseInt(inputs[0]);
            int score = Integer.parseInt(inputs[1]);
            ary[i] = new Work(day, score);
        }

        Arrays.sort(ary, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                if (o1.day.equals(o2.day)) {
                    return o1.score.compareTo(o2.score);
                }
                return o1.day.compareTo(o2.day);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (pq.size() < ary[i].day) {
                pq.add(ary[i].score);
            } else if (pq.peek() < ary[i].score) {
                pq.poll();
                pq.add(ary[i].score);
            }
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}

/*

        Arrays.sort(ary, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                if(o2.day.equals(o1.day)){
                    return o2.score.compareTo(o1.score);
                }
                return o2.day.compareTo(o1.day);
            }
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int answer = 0;
        for(int i = ary[0].day; i > 0 ; i--) {
            for(int j = 0 ; j< N ;j++) {
                if(ary[j].day == i) pq.add(ary[j].score);
                else if(ary[j].day < i) break;
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }
        System.out.println(answer);
    }

 */


