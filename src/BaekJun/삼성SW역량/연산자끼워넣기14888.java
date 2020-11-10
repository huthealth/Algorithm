package BaekJun.삼성SW역량;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 연산자끼워넣기14888 {
    static int N;
    static int[] numbers;
    //static List<Integer> operators = new ArrayList<>();
    static int[] operators = new int[4];
    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MULTIPLY = 2;
    static final int DIVIDE = 3;
    static int minValue=  Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        numbers = new int[N];
        //operators = new int[N-1];
        for(int i = 0 ; i< N ; i++){
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        inputs = br.readLine().split(" ");
        for(int i = 0 ; i< 4; i++){
            int count = Integer.parseInt(inputs[i]);
            operators[i] = count;
            //for(int j = 0 ; j< count; j++) operators.add(i);
        }

        getOrder(new ArrayList<>());
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void getOrder(ArrayList<Integer> order) {
        if(order.size() == N-1){
            getMinMaxValue(order);
            return;
        }

        for(int i = 0 ; i< operators.length;i++){
            if(operators[i] <= 0) continue;
            order.add(i);
            operators[i]--;
            getOrder(order);
            operators[i]++;
            order.remove(order.size()-1);
        }
    }

    private static void getMinMaxValue(ArrayList<Integer> order) {
        int now = numbers[0];
        for(int i = 0 ; i< order.size(); i++){
            Integer operator = order.get(i);
            if(operator == PLUS){
                now += numbers[i+1];
            }
            else if( operator == MINUS){
                now -= numbers[i+1];
            }
            else if(operator == MULTIPLY){
                now *= numbers[i+1];
            }
            else {
                if( now < 0) {
                    now = Math.abs(now);
                    now /= numbers[i+1];
                    now -= now*2;
                }
                else {
                    now /= numbers[i+1];
                }
            }
        }
        maxValue = Math.max(maxValue,now);
        minValue = Math.min(minValue,now);
    }
}
