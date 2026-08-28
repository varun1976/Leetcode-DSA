class Solution {

    // this can also be solved as if there is a cycle exist in graph
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V=numCourses;
        int indegree[]=new int[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int edge[]:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        
        for(int i=0;i<V;i++){
            for(int adjVer:adj.get(i)){
                indegree[adjVer]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0)
                q.offer(i);
        }

        int topoCount=0;
        while(!q.isEmpty()){
            int ver=q.poll();
            topoCount++;
            for(int adjVer:adj.get(ver)){
                indegree[adjVer]--;
                if(indegree[adjVer]==0)
                    q.offer(adjVer);
            }
        }
        if(topoCount==V) return true;
        return false;
    }
    
}