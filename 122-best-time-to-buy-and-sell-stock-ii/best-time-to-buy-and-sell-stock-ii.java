class Solution {
    public static int f(int i,int canBuy,int prices[],int n,int dp[][]){
        if(i==n) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        int profit;
        if(canBuy==1){
            int buy=-prices[i]+f(i+1,0,prices,n,dp);
            int dontBuy=0+f(i+1,1,prices,n,dp);
            profit=Math.max(buy,dontBuy);
        }
        else{
            int sell=prices[i]+f(i+1,1,prices,n,dp);
            int dontSell=0+f(i+1,0,prices,n,dp);
            profit=Math.max(sell,dontSell);
        }
        return dp[i][canBuy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ahead[]=new int[2];
        int curr[]=new int[2];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    int buy=-prices[i]+ahead[0];
                    int dontBuy=0+ahead[1];
                    curr[j]=Math.max(buy,dontBuy);
                }
                else{
                    int sell=prices[i]+ahead[1];
                    int dontSell=0+ahead[0];
                    curr[j]=Math.max(sell,dontSell);
                }
            }
            ahead=curr;
        }

        return ahead[1];
    }
}