package Programmers;
/*
public class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;
        if(n == 1) return 2;
        StringBuilder binaryStr = new StringBuilder(toBinary(n));
        String nextBigNumStr = findNextBigNum(binaryStr);
        answer = toInt(nextBigNumStr);
        return answer;
    }

    private int toInt(String nextBigNumStr) {
        int len = nextBigNumStr.length();
        int count = 0;
        int ret = 0;
        for(int i = len-1; i >= 0; i--){
            if(nextBigNumStr.charAt(i) == '1'){
                ret += Math.pow(2,count);
            }
            count++;
        }
        return ret;
    }

    private String findNextBigNum(StringBuilder binaryStr) {
        int rightestOneIndex = -1;
        int foundZero = -1;
        int strLen = binaryStr.length();
        int count = 0;
        int count2 = 0;
        for(int i = 0 ; i < strLen; i++){
            if(binaryStr.charAt(i) == '1') rightestOneIndex = i;
        }
        for(int i = rightestOneIndex-1; i >= 0; i-- ){
            if(binaryStr.charAt(i) == '0') {
                foundZero = i;
                break;
            }
        }
        if(foundZero == -1) {
            if(rightestOneIndex != strLen) {
                binaryStr.setCharAt(strLen-1,'1');
                return binaryStr.toString();
            }
            String subStr = binaryStr.substring(1);
            return "10"+subStr;
        }
        binaryStr.setCharAt(foundZero,'1');
        binaryStr.setCharAt(foundZero+1,'0');
        count = rightestOneIndex - (foundZero+2)+1;
        for(int i = foundZero+2; i<= rightestOneIndex; i++){
            binaryStr.setCharAt(i,'0');
        }
        while(count > 0){
            binaryStr.setCharAt(strLen-1-count2,'1');
            count--;
            count2++;
        }
        return binaryStr.toString();
    }

    private String toBinary(int n) {
        String num = "";
        while(n/2 > 0){
            int mod = n%2;
            n /=2;
            num = Integer.toString(mod) + num;
        }
        num = "1" + num;
        return num;
    }
    public static void main(String... args){
        다음큰숫자 a = new 다음큰숫자();
        System.out.println( a.solution(15));
    }
}
 */
/*
시작 숫자n을 1씩 증가 시키면서 시작 숫자(2진수)의 1 개수와 비교
1의 개수가 같을 경우 n이 다음큰 숫자이므로 return

틀린 이유 :  시간 복잡도 생각x
막연하게 백만 이하의 숫자n을 1씩 더하면서 2진법으로 변환 후 1의 개수를 count하는 방식은
시간초과가 날것이라고 생각하고 고려도 하지않고 규칙을 찾다 헤맴

숫자 n이 백만이여도 2진수의 길이가20을 넘지 않는다. -> 20번의 비교 필요(getCount메소드안에서)
다음 큰 숫자를 찾는 경우 중 가장 많은 시도를 할 경우는 2^19 에서 2^20이 되는 경우인데( 10000...0(길이19) -> 1000.0(길이20))
2^19는 약 50만 , 2^20은  약 백만

최악의 경우 약 19번의 비교 * 50만번의 1증가 이므로 1초안에 성공할 수 있다.
 */

public class 다음큰숫자 {
    public int solution(int n) {
        int countOne = getCount(n);
        while(n <= 1000000){
            int countOne2 = getCount(++n);
            if(countOne == countOne2) break;
        }

        return n;
    }

    private int getCount(int n) {
        int temp = n;
        int count = 0;
        while(temp > 0){
            if( (temp & 1) == 1) count++;
            temp = temp >> 1;
        }
        return count;
    }

}