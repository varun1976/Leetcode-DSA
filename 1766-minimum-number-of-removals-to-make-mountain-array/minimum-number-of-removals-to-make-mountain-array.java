class Solution {
    public static void rev(int[] arr) {
        int l = 0, r = arr.length - 1;
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    public static int[] longestIncreasingSubsequence(int arr[]){
        int n=arr.length;
        int dp[]=new int[n];
        int maxi=1;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int prev=0;prev<i;prev++){
                if(arr[prev]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[prev]+1);
                }
            }
        }
        return dp;
    }
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int dp1[]=longestIncreasingSubsequence(nums);
        rev(nums);
        int dp2[]=longestIncreasingSubsequence(nums);
        int maxi=0;
        for(int i=0;i<n;i++){
            if(dp1[i]>1 && dp2[n-i-1]>1)
                maxi=Math.max(maxi,dp1[i]+dp2[n-i-1]-1);
        }
        return n-maxi;
    }
}