class Solution {
    public static int f(int i,int j1,int j2,int grid[][],int m,int n,Integer dp[][][]){
        if(i<0||i>=m||j1<0||j1>=n||j2<0||j2>=n) return -(int)1e8;
        if(i==m-1){
            if(j1==j2) return grid[i][j1];
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=null) return dp[i][j1][j2];
        int maxi=0;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                if(j1==j2) maxi=Math.max(maxi,grid[i][j1]+f(i+1,j1+dj1,j2+dj2,grid,m,n,dp));
                else maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+f(i+1,j1+dj1,j2+dj2,grid,m,n,dp));
            }
        }
        return dp[i][j1][j2]=maxi;
    }
    public int cherryPickup(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Integer dp[][][]=new Integer[m][n][n];
        return f(0,0,n-1,grid,m,n,dp);
    }
}