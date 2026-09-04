class Solution {
    public static int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(List<Integer> connection : connections){
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        int tin[] = new int[n];
        int low[] = new int[n];
        boolean vis[] = new boolean[n];

        dfs(0, -1, vis, tin, low, res, adj);

        return res;
    }

    public static void dfs(int ver, int par, boolean vis[], int tin[], int low[],
                           List<List<Integer>> res, ArrayList<ArrayList<Integer>> adj) {

        vis[ver] = true;
        tin[ver] = low[ver] = timer;
        timer++;

        for(int adjVer : adj.get(ver)){
            if(adjVer == par) continue;

            if(!vis[adjVer]){
                dfs(adjVer, ver, vis, tin, low, res, adj);
                low[ver] = Math.min(low[ver], low[adjVer]);
                if(low[adjVer] > tin[ver]){
                    res.add(Arrays.asList(ver,adjVer));
                }
            }
            else{
                low[ver] = Math.min(low[ver], tin[adjVer]);
            }
        }
    }
}