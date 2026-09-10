class Solution {
    int f(int r1,int c1,int r2,int[][] grid,int n,Integer[][][] dp) {
        int c2=r1+c1-r2;
        if(r1>=n||c1>=n||r2>=n||c2>=n||grid[r1][c1]==-1||grid[r2][c2]==-1) return -(int)1e8;
        if(r1==n-1&&c1==n-1) return grid[r1][c1];
        if(dp[r1][c1][r2]!=null) return dp[r1][c1][r2];
        int cherries=grid[r1][c1];
        if(r1!=r2||c1!=c2) cherries+=grid[r2][c2];
        int hh=f(r1,c1+1,r2,grid,n,dp);
        int vv=f(r1+1,c1,r2+1,grid,n,dp);
        int hv=f(r1,c1+1,r2+1,grid,n,dp);
        int vh=f(r1+1,c1,r2,grid,n,dp);
        return dp[r1][c1][r2]=cherries+Math.max(Math.max(hh,vv),Math.max(hv,vh));
    }

    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        Integer[][][] dp=new Integer[n][n][n];
        return Math.max(0,f(0,0,0,grid,n,dp));
    }
}