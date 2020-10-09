package 알고리즘인터뷰.정렬;

import java.util.Arrays;

public class Sort_Color {
    public void sortColors(int[] nums) {
        int[] rwb = new int[3];
        Arrays.fill(rwb,9999);
        int len = nums.length;
        for(int i = 0 ; i<len; i++){
            rwb[nums[i]] = i;

                if(nums[i] == 0){
                    int minIndex = -1;
                    minIndex = Math.min(rwb[1],rwb[2]);
                    if( minIndex < i) swap(i,minIndex,nums,rwb);
                }
                else if(nums[i] == 1){
                    if(rwb[2] < i) swap(i,rwb[2],nums,rwb);

                }
                else {
                    for(int j = nums.length-1; j >i; j--){
                        if(nums[j] != 2) {
                            swap(i,j,nums,rwb);
                            len = j;
                            break;
                        }
                    }
                }
                for(int j = 0 ; j < nums.length; j++) System.out.print(nums[j]+" ");
                System.out.println();
            }

    }
    public void swap(int i,int j ,int[] nums,int[] rwb) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        rwb[nums[i]] = i;
        rwb[nums[j]] = j;


    }

    public static void main(String[] args) {
        Sort_Color s = new Sort_Color();
        int[] ary = {2,0,2,1,1,0};
        s.sortColors(ary);
    }
}
