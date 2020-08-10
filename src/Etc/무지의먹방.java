package Etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 무지의먹방 {
    public static class Entity {
        Integer food_time;
        Integer index;
        Entity(int ft, int i){
            food_time = ft;
            index = i;
        }
    }
    public int solution(int[] food_times, long k) {
        List<Entity> foodTimeList = new ArrayList<>();

        for(int i = 0; i< food_times.length;i++){
            foodTimeList.add(new Entity(food_times[i],i));
        }
        Collections.sort(foodTimeList, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return o1.food_time.compareTo(o2.food_time);
            }
        });
// 제일 작은 time이 k 보다 크다면?
        int i =0; int timeSum = 0;
        for(i= 0;i < foodTimeList.size();i++){
            long time = (foodTimeList.get(i).food_time- timeSum) * (foodTimeList.size() - i);
            if( k < time) break;
            k -= time;
            timeSum = foodTimeList.get(i).food_time;
        }
        if( i == foodTimeList.size()) return -1;

        for(int j = 0; j<i; j++){
            foodTimeList.get(j).food_time = 0;
        }
        for(int j = i; j < foodTimeList.size();j++){
            foodTimeList.get(j).food_time -= timeSum;
        }

        Collections.sort(foodTimeList, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return o1.index.compareTo(o2.index);
            }
        });

        i = -1;
        while(k>0) {
            boolean isDone = true;
            for(int j = 0;j<foodTimeList.size();j++){
                if(k>0 && foodTimeList.get(j).food_time > 0){
                    isDone = false;
                    i = (i+1) % foodTimeList.size();
                    k--;
                    foodTimeList.get(j).food_time--;
                }
            }
            if(isDone) return -1;
        }

        for(i = i+1;i<i+foodTimeList.size();i++) {
            if (foodTimeList.get(i%foodTimeList.size()).food_time > 0) return i%foodTimeList.size() + 1;
        }

        return -1;
    }

    public static void main(String... args){
        무지의먹방 a = new 무지의먹방();
        int[] b = {4,1,1,5};
        int c = 5;
        System.out.println(a.solution(b,c));
    }
}
