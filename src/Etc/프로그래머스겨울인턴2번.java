package Etc;

public class 프로그래머스겨울인턴2번 {

    public long findNum(long num){
        int count = 0;
        long left = 0;
        long ret = 0;
        long temp = num;

        while(temp > 1){
            temp /= 2;
            count++;
        }

        ret = (long)Math.pow(3,count);
        left = num - (long)Math.pow(2,count);

        if(left == 0) return ret;
        return ret + findNum(left);
    }

    public static void main(String... args){
        long a = 1000000000;
        프로그래머스겨울인턴2번 p = new 프로그래머스겨울인턴2번();
        System.out.println(p.findNum(a));
    }
}

/*
입력 n이 10^10이다 -> O(N)으로도 풀면 시간초과 -> O(lgN)으로 풀어야함 -> 이분검색
규칙 :
3^0 3^1 (3^1+3^0) 3^2 (3^2+3^0) (3^2+3^1) (3^2+(3^1+3^0)) 3^3 ...
3의 x승값은 2^x승번째에 있다. ( 3^1은 2^1번째에 3^2는 2^2번째에 ..)

n번째 숫자를 찾기
-> 만약 n이 2의 배수라면 n번(2^x번) 숫자는 3^x이다.
-> 2의 배수 아니라면 2로 최대한 나눈다(x번). 2^x번째 숫자로부터 나머지만큼 떨어진 곳에 존재하는 값이 정답.
-> 정답은 3^x + 나머지y만큼 떨어진 곳에 존재하는 숫자
->  나머지y만큼 떨어진 숫자 찾기
->  만약 y가 2의 배수라면 y번(2^y번) 숫자는 3^y이다.
->  2의 배수 아니라면 2로 최대한 나눈다(x번). 2^x번째 숫자로부터 나머지만큼 떨어진 곳에 존재하는 값이 정답.

 */