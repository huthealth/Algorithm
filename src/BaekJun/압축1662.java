package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class 압축1662 {
    static int[] endIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;
        endIndex = new int[input.length()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') {
                endIndex[stack.pop()] = i;
            }
        }
        System.out.println(depression(input, 0, input.length() - 1));
    }

    private static int depression(String input, int start, int end) {
        int total = 0 ;
        for(int i = start; i<=end; i++){
            char c = input.charAt(i);
            if(c =='('){
                int temp = depression(input,i+1,endIndex[i]);
                total += temp * (Character.getNumericValue(input.charAt(i-1)));
                total--;
                i = endIndex[i];
            }
            else if(c != ')'){
                total++;
            }
        }
        return total;
    }
}


// 메모리 초과
/*public class 압축1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<String> stack = new ArrayDeque<>();
        for(int i = 0 ; i< input.length(); i++) {
            if(input.charAt(i) == ')'){
                StringBuilder body = new StringBuilder();
                StringBuilder temp = new StringBuilder();
                StringBuilder prefix = new StringBuilder();
                int cnt=  0;
                while(!stack.isEmpty()) {
                    String now;
                    if(stack.peekFirst().equals("(")) {
                        if (cnt == 0) {
                            cnt = 1;
                            stack.pop();
                            if(stack.isEmpty()) break;
                            now = stack.pop();
                            for (int j = 0; j < Integer.parseInt(now); j++) body.append(temp);
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        now = stack.pop();
                        if(cnt == 0) {temp.append(now);}
                        else prefix.append(now);
                    }
                }
                stack.push(prefix.append(body).toString());
            }
            else {
                stack.push(Character.toString(input.charAt(i)));
            }
        }
        System.out.println(stack.pop().length());
    }
}*/
