package Etc;

import java.util.*;

public class 후보키 {
    int[] visited;
    String[][] student;
    List<ArrayList<Integer>> candidates = new ArrayList<>();
    int col;
    int row;

    public void getMax(int now) {
        if (now != col) {
            visited[now] = 1;
            getMax(now + 1);
            visited[now] = 0;
            getMax(now + 1);
            return;
        }
        String[] candidate = new String[row];
        //arrayfill
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            if (visited[i] == 1) {
                temp.add(i);
                for (int j = 0; j < row; j++) {
                    candidate[j] += student[j][i];
                }
            }
        }
        if(temp.size() == 0) return ;
        for(int i =0;i<row-1;i++){
            for(int j = i+1;j<row;j++){
                if(candidate[i].equals(candidate[j])) {
                    return ;
                }
            }
        }
        boolean ok = true;
        for(int i =0;i<candidates.size();i++){
            int size =candidates.get(i).size();
            int cnt =0;
            for(int j=0;j<size;j++){
                for(int k =0;k<temp.size();k++){
                    if(candidates.get(i).get(j).equals(temp.get(k))) cnt++;
                }
            }
            if(cnt == size) {
                ok = false;
                break;
            }
        }
        if(ok) candidates.add(temp);
    }

    public int solution(String[][] relation) {
        int answer = 0;
        col = relation[0].length;
        row = relation.length;
        visited = new int[col];
        student = relation;
        getMax(0);
        Collections.sort(candidates, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() > o2.size()) return 1;
                if(o1.size() < o2.size()) return -1;
                return 0;
            }
        });

        answer = candidates.size();
        for(int i =0;i<answer;i++){
            for(int j=0;j<candidates.get(i).size();j++){
                System.out.println(candidates.get(i).get(j)+ " ");
            }
            System.out.println();
        }
        return answer;
    }
    public static void main(String... args){
        후보키 a = new 후보키();
        String[][] b = {{"100","ryan","music","2"}};
        System.out.println(a.solution(b));
    }
}

