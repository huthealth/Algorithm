package 알고리즘인터뷰;

public class TrappingRainWater {
    public int trap(int[] height) {
        int lo =0;
        int hi = 0;
        int lh = height[0];

        int n = height.length;
        int water = 0;
        while(hi < n-1) {
            int minH = 0;
            int nh = height[hi+1];
            boolean up = false;
            for(int i = hi+1; i< n ; i++) {
                if(height[i] >= lh) {
                    up = true;
                    nh = height[i];
                    hi = i;
                    break;
                }
                if(nh < height[i]){
                    up = true;
                    nh = height[i];
                    hi = i;
                }
            }
            minH = Math.min(lh,nh);
            for(int i = lo+1; i< hi; i++) {
                if(height[i] >= minH) continue;
                water += minH - height[i];
            }
            lo = hi;
            lh = nh;
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] ary = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println( t.trap(ary));
    }
}
