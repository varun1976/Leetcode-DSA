class Solution {
    static final long MOD=1000000007;

    long f(int i,int k,int open,int n,Long[][][] dp) {
        if(k<0) return 0;
        if(i==n) {
            if(k==0&&open==0) return 1;
            return 0;
        }
        if(dp[i][k][open]!=null) return dp[i][k][open];

        if(open==0) {
            long notTake=f(i+1,k,0,n,dp);
            long take=f(i+1,k,1,n,dp);
            return dp[i][k][open]=(notTake+take)%MOD;
        }

        long notTake=f(i+1,k,1,n,dp);
        long take=f(i+1,k-1,0,n,dp);
        long newOpen=f(i+1,k-1,1,n,dp);

        return dp[i][k][open]=(notTake+take+newOpen)%MOD;
    }

    public int numberOfSets(int n,int k) {
        Long[][][] dp=new Long[n][k+1][2];
        return (int)f(0,k,0,n,dp);
    }
}