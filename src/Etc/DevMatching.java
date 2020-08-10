package Etc;

public class DevMatching {
    static final int INF = 999999999;
    static int[] N;
    static int K;

    public static void swap(int index1, int index2){
        int temp = N[index1];
        N[index1] = N[index2];
        N[index2] = temp;
    }

    public static boolean checkK(){
        for(int i =0;i<N.length-1;i++){
            if(Math.abs(N[i]-N[i+1]) >K) return false;
        }
        return true;
    }
    public static int swapCount(int now, int length){
        //System.out.println("현재 : "+now);
        //for(int i =0;i<N.length;i++) System.out.print(N[i]+" ");
        //System.out.println();
        if(now == length-1){
            if(checkK())
                return 0;
            else
                return INF;
        }

        int ret = INF;
        ret = Math.min(ret,swapCount(now+1,length));
        for(int i =now+1;i<length;i++){
            swap(now,i);
            ret = Math.min(ret,swapCount(now+1,length)+1);
            swap(now,i);
        }
        return ret;

    }

    public static int solution(int[] numbers, int k){
        N = numbers;
        K =k;
        int answer = swapCount(0,numbers.length);
        if(answer == INF) answer = -1;
        return answer;
    }

    public static void main(String... args){
        int[] ary = {60,80,30,70,500,10,40,20};
        int k = 10;
        System.out.println(solution(ary,k));
    }

}
