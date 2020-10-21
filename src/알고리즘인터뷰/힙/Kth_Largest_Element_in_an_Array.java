package 알고리즘인터뷰.힙;

import java.util.*;

public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer::compareTo));
        for(int i = 0 ; i< nums.length; i++) pq.add(nums[i]);
        for(int i = 1 ; i< k; i++) pq.poll();
        return pq.poll();
    }
}
