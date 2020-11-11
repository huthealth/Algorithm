package 알고리즘인터뷰.이진검색;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        int lo = 0;
        int hi = nums.length - 1;
        int start = -1;
        int end = -1;
        int mid = (lo + hi) / 2;

        while (lo <= hi) {
            int now = nums[mid];
            if (now >= target) {
                if (now == target) {
                    start = mid;
                }
                hi = mid - 1;
            } else lo = mid + 1;
            mid = (lo + hi) / 2;
        }

        if (start == -1) {
            answer[0] = -1;
            answer[1] = -1;
            return answer;
        }
        lo = start;
        hi = nums.length - 1;
        end = start;
        mid = (lo + hi) / 2;

        while (lo <= hi) {
            int now = nums[mid];
            if (now > target) hi = mid - 1;
            else {
                if (now == target) end = mid;
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }
        answer[0] = start;
        answer[1] = end;
        return answer;
    }

}
