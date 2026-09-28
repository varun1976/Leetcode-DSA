class Solution {
    public int maxDepth(String s) {
        int netBrac=0,maxi=0;
        for(char ch:s.toCharArray()){
            if(ch=='(')
                netBrac+=1;
            if(ch==')')
                netBrac-=1;
            maxi=Math.max(netBrac,maxi);
        }
        return maxi;
    }
}