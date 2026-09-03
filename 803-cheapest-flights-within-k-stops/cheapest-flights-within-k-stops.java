class Pair{
    int node,wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}
class Tuple{
    int stops,node,cost;
    Tuple(int stops,int node,int cost){
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int edge[]:flights){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(0,src,0));
        while(!q.isEmpty()){
            Tuple currNode=q.poll();
            int stops=currNode.stops;
            int node=currNode.node;
            int cost=currNode.cost;
            if(stops>k) continue;
            for(Pair adjPair:adj.get(node)){
                int adjNode=adjPair.node;
                int eWt=adjPair.wt;
                if(cost+eWt<dist[adjNode]){
                    dist[adjNode]=cost+eWt;
                    q.offer(new Tuple(stops+1,adjNode,dist[adjNode]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
            return -1;
        return dist[dst];
    }
}