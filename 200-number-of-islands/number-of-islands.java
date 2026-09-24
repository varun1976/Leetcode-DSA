class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int islands=0;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    islands++;
                    dfs(grid,vis,i,j,n,m);
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid,boolean vis[][],int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m || vis[row][col] || grid[row][col]!='1') return;
        vis[row][col]=true;
        dfs(grid,vis,row-1,col,n,m);
        dfs(grid,vis,row,col+1,n,m);
        dfs(grid,vis,row+1,col,n,m);
        dfs(grid,vis,row,col-1,n,m);
    }
}