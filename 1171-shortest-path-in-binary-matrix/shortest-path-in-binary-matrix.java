class Pair{
    int row,col,dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution{
    public int shortestPathBinaryMatrix(int[][] grid){
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int dr[]={-1,-1,0,1,1,1,0,-1};
        int dc[]={0,1,1,1,0,-1,-1,-1};
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],(int)1e6);
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
        q.add(new Pair(0,0,1));
        dist[0][0]=1;
        while(!q.isEmpty()){
            Pair currPair=q.poll();
            int currRow=currPair.row;
            int currCol=currPair.col;
            int currDist=currPair.dist;
            if(currDist>dist[currRow][currCol]) continue;
            if(currRow==n-1 && currCol==n-1) return currDist;
            for(int i=0;i<8;i++){
                int adjRow=currRow+dr[i];
                int adjCol=currCol+dc[i];
                if(adjRow>=0 && adjRow<n && adjCol>=0 && adjCol<n && grid[adjRow][adjCol]==0){
                    int newDist=currDist+1;
                    if(newDist<dist[adjRow][adjCol]){
                        dist[adjRow][adjCol]=newDist;
                        q.add(new Pair(adjRow,adjCol,newDist));
                    }
                }
            }
        }
        return -1;
    }
}