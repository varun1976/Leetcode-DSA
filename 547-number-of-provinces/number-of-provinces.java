class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;
        int province=0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                province++;
                dfs(i,adj,vis);
            }
        }
        return province;
    }

    public static void dfs(int ver,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        if(vis[ver]) return;
        vis[ver]=true;
        for(int adjVer:adj.get(ver)){
            if(!vis[adjVer])
                dfs(adjVer,adj,vis);
        }
    }
}