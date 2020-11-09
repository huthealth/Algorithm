package 알고리즘인터뷰.배열;

public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int now = 1;

        for(int i = 0 ; i < nums.length; i++) {
            now *= nums[i];
            answer = Math.max(answer,now);
            if(now == 0) now = 1;
        }

        now = 1;
        for(int i = nums.length -1 ; i >= 0 ; i--) {
            now *= nums[i];
            answer = Math.max(answer,now);
            if(now == 0 ) now = 1;
        }
        return answer;

    }
}
