import java.util.Arrays;

public class a0_1Knapsack {
    
    // Time Complexity: O(n * W)   // n = number of items, W = capacity
    // Space Complexity: O(n * W)
    public static int knapsackDPTab(int val[],int wt[],int W){    

        int[][]dp= new int[val.length+1][W+1];  
        

        for (int i = 1; i < val.length+1; i++) {       // where i is itemas and j is weight
            
            for (int j = 1; j < W+1; j++) {       // j is capacity (W)
                
                int v=val[i-1];   // 0 to val.length it goes
                int w=wt[i-1];   // same

                if (w<=j) {  // w current weight
                    
                    int incProfit=v+dp[i-1][j-w]; //include weight
                    int exeProfit=dp[i-1][j]; //exclude weight
                    dp[i][j]=Math.max(incProfit, exeProfit);

                } else {
                    dp[i][j]=dp[i-1][j]; // exclude if weight is grater than capacity..
                }
            }
        }

        print(dp);

        return dp[val.length][W];
    }

    // Time Complexity: O(n * W)   // total table cells printed
    // Space Complexity: O(1) extra
    public static void print(int[][] dp) {
        int i=0;
        for (int[] is : dp) {
            System.out.print("i="+(i++)+" |");
            for (int is2 : is) {
                System.out.print(is2+" |");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {    // there are 2 possiblity of evry weight/product were it include or exclude so we use two recusion call.
        
        int val[]={15,14,10,45,30}; // cost of each weight
        int wt[]={2,5,1,3,4};      // weight
        int W=7;        // Max capacity of Bag

        System.out.println("Max Profit: " + knapsackDPTab(val, wt, W));
    }
}
