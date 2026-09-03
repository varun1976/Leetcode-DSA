class DisjointSet{
    int rank[],parent[],size[];
    DisjointSet(int n){
        rank=new int[n+1];
        parent=new int[n+1];
        size=new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findUpar(int u){
        if(parent[u]==u) return u;
        return parent[u]=findUpar(parent[u]);
    }
    
    public void unionByRank(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        
        if(ulp_u==ulp_v) return;
        if(rank[ulp_u]<rank[ulp_v])
            parent[ulp_u]=ulp_v;
        else if(rank[ulp_v]<rank[ulp_u])
            parent[ulp_v]=ulp_u;
        else{
            parent[ulp_u]=ulp_v;
            rank[ulp_v]++;
        }
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        
        if(ulp_u==ulp_v) return;
        if(size[ulp_u]<size[ulp_v]){
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else{
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==0) continue;
                for(int i=0;i<4;i++){
                    int adjRow=r+dr[i];
                    int adjCol=c+dc[i];
                    if(adjRow>=0 && adjRow<n && adjCol>=0 && adjCol<n && grid[adjRow][adjCol]==1){
                        int node=r*n+c;
                        int adjNode=adjRow*n+adjCol;
                        ds.unionBySize(node,adjNode);
                    }
                } 
            }
        }
        int maxSize=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==1) continue;
                HashSet<Integer> set=new HashSet<>();
                for(int i=0;i<4;i++){
                    int adjRow=r+dr[i];
                    int adjCol=c+dc[i];
                    if(adjRow>=0 && adjRow<n && adjCol>=0 && adjCol<n && grid[adjRow][adjCol]==1){
                        int adjNode=adjRow*n+adjCol;
                        set.add(ds.findUpar(adjNode));
                    }
                }
                int adjIslandSize=0;
                for(int x:set)
                    adjIslandSize+=ds.size[x];
                maxSize=Math.max(maxSize,adjIslandSize+1);
            }
        }

        for(int i=0;i<n*n;i++){
            if (ds.findUpar(i)==i){
                maxSize=Math.max(maxSize,ds.size[i]);
            }
        }
        return maxSize;
    }
}