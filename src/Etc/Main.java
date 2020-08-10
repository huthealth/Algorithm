package Etc;

import java.util.*;

public class Main {
    static double[][] cache;
    static int lastDay;
    static int destination;
    static Map<Integer,LinkedList<Integer>> map;
    public static double catchDunibal( int day,int village){
        if(day == lastDay){
            if(village == destination)
                return 1;
            else
                return 0;
        }

        if(cache[day][village] != -1)
            return cache[day][village];
        double ret = 0;
        int len = map.get(village).size();
        for(int i =0;i<len;i++){
            int afterVillage = map.get(village).get(i);
            ret += (catchDunibal(day+ 1,afterVillage) / len);
        }
        return cache[day][village] = ret;
    }

    public static void main(String... args){
        Scanner sc =new Scanner(System.in);
        int C = sc.nextInt();
        for(int i =0;i<C;i++){

            int villages;
            villages= sc.nextInt();
            lastDay = sc.nextInt();
            int start = sc.nextInt();

            cache = new double[101][villages];


            map = new HashMap<>();
            for(int j =0;j<villages;j++){
                LinkedList<Integer> temp= new LinkedList<>();
                for(int k=0;k<villages;k++){
                    int village = sc.nextInt();
                    if(village != 0) {
                        temp.addLast(k);
                    }
                }
                map.put(j,temp);
            }

            int searchNum = sc.nextInt();
            for(int j=0;j<searchNum;j++){
                for(int k=0;k<101;k++) {
                    for(int l=0;l<villages;l++) {
                        cache[k][l] = -1.0;
                    }
                }

                destination = sc.nextInt();
                System.out.print(catchDunibal(0,start)+" ");
            }
            System.out.println();

        }
    }
}
