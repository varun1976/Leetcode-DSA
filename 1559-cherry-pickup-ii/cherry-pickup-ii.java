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

    //Tabulation Solution
    public int cherryPickupTabulation(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Integer dp[][][]=new Integer[m][n][n];
        for(int j1=0;j1<n;j1++){
            for(int j2=0;j2<n;j2++){
                if(j1==j2) dp[m-1][j1][j2]=grid[m-1][j1];
                else dp[m-1][j1][j2]=grid[m-1][j1]+grid[m-1][j2];
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j1=n-1;j1>=0;j1--){
                for(int j2=n-1;j2>=0;j2--){
                    int maxi=0;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int nj1=j1+dj1,nj2=j2+dj2;
                            if(nj1<0||nj1>=n||nj2<0||nj2>=n) continue;
                            int value;
                            if(j1==j2) value=grid[i][j1]+dp[i+1][nj1][nj2];
                            else value=grid[i][j1]+grid[i][j2]+dp[i+1][nj1][nj2];
                            maxi=Math.max(maxi,value);
                        }
                    }
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        return dp[0][0][n-1];
    }
}