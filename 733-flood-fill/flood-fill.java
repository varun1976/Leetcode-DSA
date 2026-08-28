class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inColor=image[sr][sc];
        int n=image.length,m=image[0].length;
        boolean vis[][]=new boolean[n][m];
        dfs(image,vis,sr,sc,color,inColor,n,m);
        return image;
    }
    public void dfs(int image[][],boolean vis[][],int row,int col,int color,int inColor,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m || image[row][col]!=inColor || vis[row][col]) return;
        image[row][col]=color;
        vis[row][col]=true;
        dfs(image,vis,row-1,col,color,inColor,n,m);
        dfs(image,vis,row,col+1,color,inColor,n,m);
        dfs(image,vis,row+1,col,color,inColor,n,m);
        dfs(image,vis,row,col-1,color,inColor,n,m);
    }
}