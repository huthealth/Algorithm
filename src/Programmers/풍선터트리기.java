package Programmers;

public class 풍선터트리기 {
    public int solution(int[] a) {
        int answer = a.length;

        int leftMin = a[0];
        int rightMin = a[a.length - 1];
        boolean[] leftCheck = new boolean[a.length];
        boolean[] rightCheck = new boolean[a.length];
        for (int i = 1; i < a.length; i++) {
            if (leftMin > a[i]) {
                leftCheck[i] = true;
                leftMin = a[i];
            }
        }

        for (int i = a.length - 2; i >= 0; i--) {
            if (rightMin > a[i]) {
                rightCheck[i] = true;
                rightMin = a[i];
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println("lc" + leftCheck[i]);
            System.out.println("rc" + rightCheck[i]);
            if (leftCheck[i] && rightCheck[i]) answer--;
        }


        return answer;
    }
}
