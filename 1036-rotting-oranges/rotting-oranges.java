class Pair{
    int row,col,time;
    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) q.add(new Pair(i,j,0));
            }
        }
        int maxTime=0;
        while(!q.isEmpty()){
            Pair currPair=q.poll();
            int currRow=currPair.row;
            int currCol=currPair.col;
            int currTime=currPair.time;
            maxTime=Math.max(maxTime,currTime);

            for(int i=0;i<4;i++){
                int adjRow=currRow+dr[i];
                int adjCol=currCol+dc[i];
                if(adjRow>=0 && adjRow<m && adjCol>=0 && adjCol<n && grid[adjRow][adjCol]==1){
                    q.add(new Pair(adjRow,adjCol,currTime+1));
                    fresh--;
                    grid[adjRow][adjCol]=2;
                }
            }
        }
        if(fresh==0) return maxTime;
        return -1;
    }
}