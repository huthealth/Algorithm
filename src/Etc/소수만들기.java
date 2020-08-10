package Etc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class 소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n-2 ; i ++) {
            for(int j = i + 1; j< n-1 ; j++) {
                for(int k = j + 1; k < n; k++) {
                    result.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for(Integer num : result) {
            boolean isFail = false;
            for(int i = 2; i< num;i++) {
                if(num % i == 0) {
                    isFail = true;
                    break;
                }
            }
            if(isFail) continue;
            answer++;
        }
        return answer;
    }

    static String readFirstLineFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
            return br.readLine();
    }
}