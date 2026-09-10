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
        Integer dp[][]=new Integer[m][n];
        return f(0,0,dungeon,dp);
    }
}