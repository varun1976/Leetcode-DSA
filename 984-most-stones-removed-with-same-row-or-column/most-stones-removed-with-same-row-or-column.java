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
    public int removeStones(int[][] stones) {

        int maxRow = 0, maxCol = 0;
        for (int[] s : stones) {
            maxRow = Math.max(maxRow, s[0]);
            maxCol = Math.max(maxCol, s[1]);
        }

        int offset = maxRow + 1;
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        HashSet<Integer> used = new HashSet<>();

        for (int[] s : stones) {
            int rowNode = s[0];
            int colNode = s[1] + offset;

            ds.unionByRank(rowNode, colNode);
            used.add(rowNode);
            used.add(colNode);
        }

        int components = 0;
        for (int node : used) {
            if (ds.findUpar(node) == node)
                components++;
        }

        return stones.length - components;
    }
}