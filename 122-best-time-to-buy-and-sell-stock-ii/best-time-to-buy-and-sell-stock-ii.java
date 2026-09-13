class Solution {
    public int f(int ind,int canBuy,int prices[],int n,Integer dp[][]){
        if(ind==n-1){
            if(canBuy==0) return prices[ind];
            return 0;
        }
        if(dp[ind][canBuy]!=null) return dp[ind][canBuy];
        int profit=0;
        if(canBuy==1){
           int buy= -prices[ind]+f(ind+1,0,prices,n,dp);
           int dontBuy= 0+f(ind+1,1,prices,n,dp);
           profit=Math.max(buy,dontBuy);
        }
        else{
            int sell=prices[ind]+f(ind+1,1,prices,n,dp);
            int dontSell=0+f(ind+1,0,prices,n,dp);
            profit=Math.max(sell,dontSell);
        }

        return dp[ind][canBuy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer dp[][]=new Integer[n][2];
        return f(0,1,prices,n,dp);
    }
}