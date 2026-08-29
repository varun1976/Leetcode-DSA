class Pair{
    int row, col, dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int dr[]={-1,-1,0,1,1,1,0,-1};
        int dc[]={0,1,1,1,0,-1,-1,-1};
        boolean vis[][]=new boolean[n][n];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,0));
        vis[0][0]=true;
        while(!q.isEmpty()){
            int currRow=q.peek().row;
            int currCol=q.peek().col;
            int currDist=q.peek().dist;
            if(currRow==n-1 && currCol==n-1) return currDist+1;
            q.poll();
            for(int i=0;i<8;i++){
                int adjRow=currRow+dr[i];
                int adjCol=currCol+dc[i];
                if(adjRow>=0 && adjRow<n && adjCol>=0 && adjCol<n && !vis[adjRow][adjCol] && grid[adjRow][adjCol]==0){
                    q.add(new Pair(adjRow,adjCol,currDist+1));
                    vis[adjRow][adjCol]=true;
                }
            }
        }
        return -1;
        
    }
}