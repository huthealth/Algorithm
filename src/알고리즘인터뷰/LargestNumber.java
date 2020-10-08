package 알고리즘인터뷰;


import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for(int i = 0; i< nums.length; i++){
            numStrs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numStrs,(a, b)->{
            int aLen = a.length();
            int bLen = b.length();
            int minLen = Math.min(aLen,bLen);
            for(int i = 0 ; i<minLen; i++ ){
                if(b.charAt(i) > a.charAt(i)) return 1;
                else if(b.charAt(i) < a.charAt(i)) return -1;
            }
            if(aLen == bLen) return 0;

            if(bLen > aLen){

                if(b.charAt(aLen) >= a.charAt(0)) return 1;
                return -1;
            }
            else {
                if(b.charAt(0) <= a.charAt(bLen)) return -1;
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder("");
        for(int i = 0 ; i<numStrs.length;i++) {
            System.out.println(numStrs[i]);
            sb.append(numStrs[i]);
        }
        return sb.toString();
    }
}