class State{
    int row,col,mask,energy,steps;
    State(int row,int col,int mask,int energy,int steps){
        this.row=row;
        this.col=col;
        this.mask=mask;
        this.energy=energy;
        this.steps=steps;
    }
}

class Solution{
    public int minMoves(String[] classroom,int energy){
        int m=classroom.length,n=classroom[0].length();
        int sr=0,sc=0,litterCount=0;
        int[][] id=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(id[i],-1);
            for(int j=0;j<n;j++){
                char ch=classroom[i].charAt(j);
                if(ch=='S'){
                    sr=i;
                    sc=j;
                }else if(ch=='L'){
                    id[i][j]=litterCount++;
                }
            }
        }
        int fullMask=(1<<litterCount)-1;
        int[][][] bestEnergy=new int[m][n][1<<litterCount];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(bestEnergy[i][j],-1);
            }
        }
        Queue<State> queue=new LinkedList<>();
        queue.offer(new State(sr,sc,0,energy,0));
        bestEnergy[sr][sc][0]=energy;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!queue.isEmpty()){
            State curr=queue.poll();
            if(curr.mask==fullMask) return curr.steps;
            if(curr.energy==0) continue;
            for(int d=0;d<4;d++){
                int nr=curr.row+dr[d],nc=curr.col+dc[d];
                if(nr<0||nr>=m||nc<0||nc>=n||classroom[nr].charAt(nc)=='X') continue;
                int newEnergy=curr.energy-1;
                int newMask=curr.mask;
                char ch=classroom[nr].charAt(nc);
                if(ch=='L') newMask|=(1<<id[nr][nc]);
                if(ch=='R') newEnergy=energy;
                if(newEnergy<=bestEnergy[nr][nc][newMask]) continue;
                bestEnergy[nr][nc][newMask]=newEnergy;
                queue.offer(new State(nr,nc,newMask,newEnergy,curr.steps+1));
            }
        }
        return -1;
    }
}