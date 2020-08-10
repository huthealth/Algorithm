package Etc;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class KakaoEn2 {
    private static class TeamEntity{
        String name;
        Integer win;
        Integer setScore;
        TeamEntity(String n, Integer w, Integer s){
            name = n;
            win  = w;
            setScore = s;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N = N * (N-1);
        Map<String,TeamEntity> teamMap = new HashMap<>();
        List<TeamEntity> teamList = new ArrayList<>();

        while(N-- > 0) {
            String input = br.readLine();
            String[] token = input.split(" ");
            String team1Name = token[0];
            int team1Score = Integer.parseInt(token[1]);
            String team2Name = token[2];
            int team2Score = Integer.parseInt(token[3]);
            int team1WinPoint,team2WinPoint;
            if(team1Score - team2Score > 0) {
                team1WinPoint = 1;
                team2WinPoint = 0;
            }
            else {
                team1WinPoint = 0;
                team2WinPoint = 1;
            }

            if(teamMap.containsKey(team1Name)) {
                teamMap.get(team1Name).win += team1WinPoint;
                teamMap.get(team1Name).setScore += team1Score - team2Score;
            }
            else {
                teamMap.put(team1Name,new TeamEntity(team1Name,team1WinPoint,team1Score - team2Score));
            }

            if(teamMap.containsKey(team2Name)) {
                teamMap.get(team2Name).win += team2WinPoint;
                teamMap.get(team2Name).setScore += team2Score - team1Score;
            }
            else {
                teamMap.put(team2Name,new TeamEntity(team2Name,team2WinPoint,team2Score - team1Score));

            }
        }
        Iterator<String> iter =  teamMap.keySet().iterator();
        while(iter.hasNext()){
            teamList.add(teamMap.get(iter.next()));
        }
        Collections.sort(teamList, new Comparator<TeamEntity>() {
            @Override
            public int compare(TeamEntity o1, TeamEntity o2) {
                if(o1.win.equals(o2.win)){
                    if(o1.setScore.equals(o2.setScore)){
                        return o1.name.compareTo(o2.name);
                    }
                    return -o1.setScore.compareTo(o2.setScore);
                }
                return -o1.win.compareTo(o2.win);
            }
        });
        for(int i = 0; i< teamList.size();i++){
            System.out.println(teamList.get(i).name+" "+teamList.get(i).win+" "+teamList.get(i).setScore);
        }
    }
}