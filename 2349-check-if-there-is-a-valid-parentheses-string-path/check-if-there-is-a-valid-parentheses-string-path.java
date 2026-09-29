class Solution {
    public boolean f(int i,int j,int balance,char[][] grid,int m,int n,Boolean[][][] dp){
        if(i<0||i==m||j<0||j==n) return false;
        if(grid[i][j]=='(') balance++;
        else balance--;
        if(balance<0) return false;
        if(i==m-1&&j==n-1) return balance==0;
        if(dp[i][j][balance]!=null) return dp[i][j][balance];

        boolean down=f(i+1,j,balance,grid,m,n,dp);
        boolean right=f(i,j+1,balance,grid,m,n,dp);

        return dp[i][j][balance]=down||right;
    }

    public boolean hasValidPath(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        if((m+n-1)%2!=0||grid[0][0]==')'||grid[m-1][n-1]=='(') return false;
        int maxBalance=m+n;
        Boolean[][][] dp=new Boolean[m][n][maxBalance+1];
        return f(0,0,0,grid,m,n,dp);
    }
}