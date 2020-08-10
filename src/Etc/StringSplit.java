package Etc;

import java.util.HashMap;
import java.util.Map;

public class StringSplit {
    Map<String,Integer> url = new HashMap<>();
    int[][] map;


    public int solution(String word, String[] pages) {
        //int answer = 0;
        word = word.toLowerCase();
        int pageSize = pages.length;
        map = new int[pageSize][pageSize];
        int[] basicScore = new int[pageSize];
        int[] outerLink =new int[pageSize];
        double[] matchScore = new double[pageSize];

        for(int i =0;i<pageSize;i++){
            String myUrl = getMyUrl(pages[i]);
            url.put(myUrl,i);
        }
        for(int i=0;i<pageSize;i++){
            basicScore[i] = getBasicScore(pages[i],word);
            matchScore[i] += basicScore[i];
        }
        for(int i =0;i<pageSize;i++){
            outerLink[i] = getOuterLink(pages[i],i);
        }
        /*
        for(int i =0;i<pageSize;i++){
            for(int j =0;j<pageSize;j++){
                if(i==j) continue;
                if(map[i][j] == 1){
                    matchScore[i] += (double)basicScore[j]/outerLink[j];
                }
            }
        }
        double maxScore = -1.0;
        for(int i =0;i<pageSize;i++){
            if(matchScore[i] > maxScore){
                answer = i;
                maxScore = matchScore[i];
            }
        }
        return answer;
    }
    */
        double maxScore = Double.MIN_VALUE;
        int answer = 0;
        for(int i = 0; i<pageSize; i++) {
            matchScore[i] = basicScore[i];
            for(int j = 0; j<pageSize; j++){
                if(i==j)
                    continue;

                if(map[j][i] == 1) {
                    matchScore[i] += ((double)basicScore[j]/outerLink[j]);
                }
            }
            if(maxScore<matchScore[i]) {
                answer = i;
                maxScore = matchScore[i];
            }
        }

        return answer;
    }

    private int getOuterLink(String page,int myself) {
        String[] pg = page.split("<a href=\"https://");
        int count = pg.length-1;
        for(int i =1;i<pg.length;i++){
            String[] temp = pg[i].split("\"/>");
            String outerLink = temp[0];
            if(url.containsKey(outerLink)){
                map[myself][url.get(outerLink)] = 1;
            }
        }
        return count;
    }

    private int getBasicScore(String page, String word) {
        page = page.toLowerCase();
        String[] pg = page.split("[^a-z]");
        int count =0;
        for(int i=0;i<pg.length;i++){
            if(word.equals(pg[i])) count++;
        }
        return count;
    }

    private String getMyUrl(String page) {
        String[] pg = page.split("<meta property=\"og:url\" content=\"https://");
        String[] temp = pg[1].split("\"/>");
        return temp[0];
    }

    public static void main(String... args){
        String line = "muzi@muzi muzi-asdf%muzzi";
        String[] ans = line.split("\\W");
        for(String a : ans) System.out.println(a);
    }
}
