package week1;

// Two pointers : BuyIndex, SellIndex Start from 0
// Increment sellIndex pointer everytime and check
// if(buy > Sell) -- loss then update BuyIndex 
// else check if global profit < new profit if yes update it
public class bestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // 5
        System.out.println(maxProfit(new int[] { 7, 2, 5, 8, 1, 3 })); // 6
    }

    public static int maxProfit(int[] shareValue) {
        int profit = 0;
        int buy = 0, sell = 0;
        for (int i = 0; i < shareValue.length; i++) {
            if (shareValue[buy] > shareValue[sell]) {
                buy = i;
                sell = i;
            } else if (profit < (shareValue[sell] - shareValue[buy])) {
                profit = shareValue[sell] - shareValue[buy];
            }
            sell++;
        }
        return profit;
    }
}