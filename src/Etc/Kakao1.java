package Etc;

public class Kakao1 {
    String H;
    int[][] phone = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
    int fingerL = 10;
    int fingerR = 11;

    public String solution(int[] numbers, String hand) {
        String answer = "";
        H =hand;
        for(int i =0;i<numbers.length;i++){
            System.out.println(i+" "+fingerL+ " "+fingerR);
            answer += getFinger(numbers[i]);
        }

        return answer;
    }
    String getFinger(int num) {
        int left = Math.abs(phone[fingerL][0] - phone[num][0]) + Math.abs(phone[fingerL][1] - phone[num][1]);
        int right = Math.abs(phone[fingerR][0] - phone[num][0]) + Math.abs(phone[fingerR][1] - phone[num][1]);

        if (num == 2 || num == 5 || num == 8 || num == 0) {
            if (left == right) {
                if (H.equals("left")) {
                    fingerL = num;
                    return "L";
                } else {
                    fingerR = num;
                    return "R";
                }
            }
            if (left > right) {
                fingerR = num;
                return "R";
            }
            fingerL = num;
            return "L";
        }
        if(num == 1 || num==4 || num== 7){
            fingerL =num;
            return "L";
        }
        fingerR =num;
        return "R";
    }
    public static void main(String... agrs){
        Kakao1 k = new Kakao1();
        int[] n = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String h = "right";
        k.solution(n,h);
    }
}
