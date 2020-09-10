package 알고리즘인터뷰;

public class longestPalindrome5 {
    private int[][] cache;
    public String longestPalindrome(String s) {
        int len = s.length();
        cache = new int[len][len];
        for(int i = 0 ; i<len; i++) {
            for(int j = 0 ; j<len; j++) cache[i][j] = -1;
        }

        if(len == 1 || len == 0) return s;
        int maxLen = 1;
        int start = 0;
        int end = 0;
        String answer = "";

        for(int i = 0 ; i < len-1; i++) {
            for(int j = len-1; j>i; j-- ) {
                int nowLen = isPalin(s,i,j,0);
                if(nowLen > maxLen) {
                    maxLen = nowLen;
                    start = i;
                    end = j;
                }
                if(maxLen > j - i +1) break;
            }

        }

        answer = s.substring(start,end+1);
        return answer;

    }

    private int isPalin(String s, int start , int end,int cnt) {
        if(start > end) return 0 + cnt*2;
        if(start == end) return 1 + cnt*2;

        if(cache[start][end] != -1) return cache[start][end];
        cache[start][end] = 0;
        if(s.charAt(start) != s.charAt(end)) return 0;
        return cache[start][end] = isPalin(s,start+1,end-1,cnt+1);

    }

    public static void main(String[] args) {
        longestPalindrome5 l = new longestPalindrome5();
        System.out.println( l.longestPalindrome("abcda"));
    }
}
