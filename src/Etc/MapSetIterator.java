package Etc;

import java.util.*;

public class MapSetIterator {
    public static void main(String... args){
        Map<String,Integer> map = new HashMap<>();
        SortedMap<String,Integer> sMap = new TreeMap<>();
        Map<String,Integer> lMap = new LinkedHashMap<>();

        Set<String> set = new HashSet<>();
        for(int i =0;i<50;i++){
            map.put(Integer.toString(i),i+100);
            sMap.put(Integer.toString(i),i+100);
            lMap.put(Integer.toString(i),i+100);
            set.add(Integer.toString(i));
        }
        Iterator<String> mapIter = map.keySet().iterator();
        Iterator<String> setIter = set.iterator();
        Iterator<String> sMapIter = sMap.keySet().iterator();
        Iterator<String> lMapIter = lMap.keySet().iterator();

        for(;lMapIter.hasNext();){
            System.out.println(lMapIter.next());
        }
    }
}
