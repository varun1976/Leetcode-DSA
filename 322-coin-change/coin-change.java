class Solution {
    public int help(int ind,int coins[],int amount,int dp[][]){
        if(ind==0){
            if(amount%coins[0]==0) return amount/coins[0];
            return (int)1e9;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notPick=help(ind-1,coins,amount,dp);
        int pick=(int)1e9;
        if(amount>=coins[ind]) pick=1+help(ind,coins,amount-coins[ind],dp);
        return dp[ind][amount]=Math.min(pick,notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int prev[]=new int[amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0) prev[j]=j/coins[0];
            else prev[j]=(int)1e9;
        }
        for(int ind=1;ind<n;ind++){
            int curr[]=new int[amount+1];
            for(int j=0;j<=amount;j++){
                int notPick=prev[j];
                int pick=(int)1e9;
                if(j>=coins[ind]) pick=1+curr[j-coins[ind]];
                curr[j]=Math.min(pick,notPick);
            }
            prev=curr;
        }
        int res=prev[amount];
        if(res>=(int)1e9) return -1;
        return res;
    }
}