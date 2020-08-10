package Etc;

import java.util.*;

public class 베스트앨범 {
    private static class Entity implements Comparable<Entity> {
        private Integer index;
        private Integer playCount;
        private Entity(int index, int playCount){
            this.index = index;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Entity o) {
            return 0;
        }
    }

    private static class Entity2 implements Comparable<Entity2>{
        private String genre;
        private Integer playCount;
        private Entity2(String genre, int playCount){
            this.genre = genre;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Entity2 o) {
            return -this.playCount.compareTo(o.playCount);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String,Integer> map = new HashMap<>();
        Map<String,List<Entity>> map2 = new HashMap<>();
        List<Entity2> list0 = new LinkedList<>();
        for(int i =0; i<genres.length;i++){
            if(map.containsKey(genres[i])){
                int played = map.get(genres[i]);
                map.put(genres[i],played+plays[i]);
                List<Entity> list = map2.get(genres[i]);
                list.add(new Entity(i,plays[i]));
            }
            else {
                map.put(genres[i],plays[i]);
                List<Entity> list = new LinkedList<>();
                list.add(new Entity(i,plays[i]));
                map2.put(genres[i],list);
            }
        }

        Iterator<String> iter0 = map.keySet().iterator();
        while(iter0.hasNext()) {
            String key = iter0.next();
            list0.add(new Entity2(key,map.get(key)));
        }
        List<Entity> ll = new ArrayList<>();
        Collections.sort(ll);
        Collections.sort(list0);
        Collections.sort(list0, new Comparator<Entity2>() {
            @Override
            public int compare(Entity2 o1, Entity2 o2) {
                return -o1.playCount.compareTo(o2.playCount);
            }
        });

        Iterator<String> iter = map2.keySet().iterator();
        while(iter.hasNext()){
            Collections.sort(map2.get(iter.next()), new Comparator<Entity>() {
                @Override
                public int compare(Entity o1, Entity o2) {
                    if(o1.playCount.equals(o2.playCount)){
                        return o1.index.compareTo(o2.index);
                    }
                    return -o1.playCount.compareTo(o2.playCount);
                }
            });
        }



        List<Integer> ans = new LinkedList<>();

        for(int i =0; i<list0.size();i++){
            String key = list0.get(i).genre;
            List<Entity> list = map2.get(key);
            if(list.size() < 2){
                ans.add(list.get(0).index);
            }
            else {
                ans.add(list.get(0).index);
                ans.add(list.get(1).index);
            }
        }

        answer = new int[ans.size()];
        for(int i =0; i<ans.size();i++) {
            answer[i] = ans.get(i);
        }
        //for(int i : answer) System.out.println(i);
        return answer;
    }
}