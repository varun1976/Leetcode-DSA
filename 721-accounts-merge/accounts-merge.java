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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        // email -> account index
        HashMap<String, Integer> mailToIndex = new HashMap<>();

        // Step 1: Union accounts that share emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                if (!mailToIndex.containsKey(mail)) {
                    mailToIndex.put(mail, i);
                } else {
                    ds.unionByRank(i, mailToIndex.get(mail));
                }
            }
        }

        // Step 2: group mails by parent
        ArrayList<String>[] mergedMails = new ArrayList[n];
        for (int i = 0; i < n; i++)
            mergedMails[i] = new ArrayList<>();

        for (String mail : mailToIndex.keySet()) {
            int parent = ds.findUpar(mailToIndex.get(mail));
            mergedMails[parent].add(mail);
        }

        // Step 3: build result
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMails[i].isEmpty()) continue;

            Collections.sort(mergedMails[i]);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // account name
            temp.addAll(mergedMails[i]);

            res.add(temp);
        }

        return res;
    }
}
