class Pair{
    int node;
    long time;
    Pair(int node,long time){
        this.node=node;
        this.time=time;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int wt=road[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        long time[]=new long[n];
        Arrays.fill(time,Long.MAX_VALUE);
        
        int ways[]=new int[n];
        int MOD=1000000007;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        
        time[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            long uTime=curr.time;
            
            if(uTime>time[u]) continue;
            
            for(Pair adjPair:adj.get(u)){
                int v=adjPair.node;
                long newTime=uTime+adjPair.time;
                
                if(newTime<time[v]){
                    time[v]=newTime;
                    ways[v]=ways[u];
                    pq.add(new Pair(v,newTime));
                }
                else if(newTime==time[v]){
                    ways[v]=(ways[v]+ways[u])%MOD;
                }
            }
        }
        
        return ways[n-1];
    }
}