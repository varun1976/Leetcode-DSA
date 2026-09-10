class Solution {
    int m,n;
    
    int f(int i,int j,int[][] dungeon,Integer dp[][]) {
        if(i==m-1 && j==n-1) return Math.max(1,1-dungeon[i][j]);
        if(i==m-1) return Math.max(1,f(i,j+1,dungeon,dp)-dungeon[i][j]);
        if(j==n-1) return Math.max(1,f(i+1,j,dungeon,dp)-dungeon[i][j]);

        if(dp[i][j]!=null) return dp[i][j];
        int down=f(i+1,j,dungeon,dp);
        int right=f(i,j+1,dungeon,dp);
        return dp[i][j]=Math.max(1,Math.min(down,right)-dungeon[i][j]);
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        m=dungeon.length;
        n=dungeon[0].length;
        int dp[][]=new int[m][n];
        dp[m-1][n-1]=Math.max(1,1-dungeon[m-1][n-1]);

        for(int j=n-2;j>=0;j--)
            dp[m-1][j]=Math.max(1,dp[m-1][j+1]-dungeon[m-1][j]);

        for(int i=m-2;i>=0;i--)
            dp[i][n-1]=Math.max(1,dp[i+1][n-1]-dungeon[i][n-1]);

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int down=dp[i+1][j];
                int right=dp[i][j+1];
                dp[i][j]=Math.max(1,Math.min(down,right)-dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}