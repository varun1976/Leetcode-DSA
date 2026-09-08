
class Solution {
    public void isSubsetSum(int sum,int nums[],boolean dp[][],int n){
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=sum) dp[0][nums[0]]=true;

        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean notPick=dp[i-1][target];
                boolean pick=false;
                if(target-nums[i]>=0) pick=dp[i-1][target-nums[i]];
                dp[i][target]=pick||notPick;
            }
        }
    }
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int totSum=0;
        for(int x:stones)
            totSum+=x;
        boolean dp[][]=new boolean[n][totSum+1];
        isSubsetSum(totSum,stones,dp,n);
        int mini=Integer.MAX_VALUE;
        for(int s1=totSum/2;s1>=0;s1--){
            if(dp[n-1][s1])
                return totSum-2*s1;
        }
        return mini;
    }
}