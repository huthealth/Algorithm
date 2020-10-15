package 알고리즘인터뷰.이진검색;

public class 이진검색 {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        int mid = (lo + hi) /2;

        while(lo <= hi) {
            if(nums[mid] == target) return mid;
            else if( nums[mid] < target) lo = mid+1;
            else hi = mid-1;
            mid = (lo + hi) / 2;
        }
        return -1;
    }
}
