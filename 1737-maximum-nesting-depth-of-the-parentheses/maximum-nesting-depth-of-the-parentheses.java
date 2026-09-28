class Solution {
    static {
        Solution sol=new Solution();
        String test="(1+(2*3)+((8)/4))+1";

        for(int i=0;i<1000;i++)
            sol.maxDepth(test);
    }

    public int maxDepth(String s) {
        int netBrac=0,maxi=0,n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='(')
                netBrac++;
            else if(ch==')')
                netBrac--;

            maxi=Math.max(maxi,netBrac);
        }

        return maxi;
    }
}