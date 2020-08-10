package Etc;

public class 쿠기구입 {
    public int solution(int[] cookie) {
        int N = cookie.length;
        int hi = 1;
        int lo = 0;
        int maxCookie = 0;
        while(hi < N) {
            int sonLeft = cookie[lo];
            int sonRight = cookie[hi];
            int tempLo = lo;
            int tempHi = hi;
            while(tempHi < N && tempLo >= 0) {
                if(sonLeft == sonRight) {
                    maxCookie = sonLeft;
                    break;
                }
                else if ( sonLeft > sonRight) {
                    if(++tempHi == N) break;
                    sonRight += cookie[tempHi];
                }
                else {
                    if(--tempLo == -1) break;
                    sonLeft += cookie[tempLo];
                }
            }
            hi++;
            lo++;
        }

        System.out.println(maxCookie);
        return maxCookie;
    }
    public static void main(String... args) {
        쿠기구입 c = new 쿠기구입();
        int[] cookie = {1,1,2,3};
        c.solution(cookie);
    }
}
