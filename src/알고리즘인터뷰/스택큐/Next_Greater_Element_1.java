package 알고리즘인터뷰.스택큐;

import java.util.*;

public class Next_Greater_Element_1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 ) return new int[0];
        int[] answer = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer,Integer> nextGreaterMap =new HashMap<>();
        // stack.push(nums2[0]);
        for(int i = 0 ; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peekFirst() < nums2[i]) {
                nextGreaterMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(),-1);
        }

        for(int i = 0 ; i < nums1.length; i++) {
            answer[i] = nextGreaterMap.get(nums1[i]);
        }
        return answer;

    }
}
