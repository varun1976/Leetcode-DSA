class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int provinces=0;
        boolean isVisited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!isVisited[i]){
                provinces++;
                dfs(i,isConnected,isVisited);
            }
        }
        return provinces;
    }
    public void dfs(int ver,int isConnected[][],boolean isVisited[]){
        if(isVisited[ver])
            return;
        isVisited[ver]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[ver][i]==1)
                dfs(i,isConnected,isVisited);
        }
    }
}