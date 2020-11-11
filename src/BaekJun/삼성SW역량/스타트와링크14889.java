package BaekJun.삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트와링크14889 {
    static int minDiff = Integer.MAX_VALUE;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt( br.readLine() );
        map = new int[N][N];
        for(int i = 0 ; i< N ; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        pickMember(0, new LinkedList<>());
        System.out.println(minDiff);
    }

    private static void pickMember(int now,Deque<Integer> members) {
        if(members.size() == N/2) {
            getScoreDiff(members);
            return;
        }

        for(int i = now; i< N; i++) {
            members.add(i);
            pickMember(i+1,members);
            members.removeLast();
        }
    }

    private static void getScoreDiff(Deque<Integer> teamA) {
        List<Integer> a = new ArrayList<>(teamA);
        List<Integer> b = new ArrayList<>();

        Set<Integer> temp = new HashSet<>();
        for(Integer member : teamA) {
            temp.add(member);
        }

        for(int i = 0 ; i< N; i++) {
            if(temp.contains(i)) continue;
            b.add(i);
        }


        int size = teamA.size();
        int teamAScore = 0;
        int teamBScore = 0;

        for(int i = 0 ; i < size-1; i++) {
            int member1 = a.get(i);
            for(int j = i+1 ; j < size; j++) {
                int member2 = a.get(j);
                teamAScore += map[member1][member2];
                teamAScore += map[member2][member1];
            }
        }

        for(int i = 0 ; i < size-1; i++) {
            int member1 = b.get(i);
            for(int j = i+1 ; j < size; j++) {
                int member2 = b.get(j);
                teamBScore += map[member1][member2];
                teamBScore += map[member2][member1];
            }
        }


        minDiff = Math.min(minDiff, Math.abs(teamAScore - teamBScore));
    }
}
