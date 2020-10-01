package 알고리즘인터뷰.배열;


public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int maxPrice = prices[n-1];
        int answer = 0;
        for(int i = n-2; i >= 0 ; i--) {
            int profit = maxPrice - prices[i] ;
            if( profit <= 0 ) {
                maxPrice = prices[i];
            }
            else {
                answer = Math.max(answer, profit);
            }
        }
        return answer;
    }
}