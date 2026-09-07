class Solution {
    public static boolean f(int i,int j,String s,String p,int m,int n){
        if(i==0 && j==0) return true;
        if(i>0 && j==0) return false;
        if(i==0 && j>=0){
            while(j!=0){
                if(p.charAt(j-1)!='*') return false;
                j--;
            }
            return true;
        }
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
            return f(i-1,j-1,s,p,m,n);
        if(p.charAt(j-1)=='*')
            return f(i-1,j,s,p,m,n) || f(i,j-1,s,p,m,n);
        return false;
    }
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean prev[]=new boolean[n+1];
        boolean curr[]=new boolean[n+1];

        prev[0]=true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                prev[j] = prev[j - 1];
            else
                prev[j] = false;
        }
        for(int i=1;i<=m;i++){
            curr[0]=false;
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    curr[j]=prev[j-1];
                else if(p.charAt(j-1)=='*')
                    curr[j]=prev[j] || curr[j-1];
                else
                    curr[j]=false;
            }
            prev=curr.clone();
        }
        return prev[n];
    }
    // public boolean isMatch(String s, String p) {
    //     int m=s.length(),n=p.length();
    //     boolean dp[][]=new boolean[m+1][n+1];

    //     dp[0][0]=true;
    //     for(int i=1;i<=m;i++)
    //         dp[i][0]=false;
    //     for (int j = 1; j <= n; j++) {
    //         if (p.charAt(j - 1) == '*')
    //             dp[0][j] = dp[0][j - 1];
    //         else
    //             dp[0][j] = false;
    //     }
    //     for(int i=1;i<=m;i++){
    //         for(int j=1;j<=n;j++){
    //             if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
    //                 dp[i][j]=dp[i-1][j-1];
    //             else if(p.charAt(j-1)=='*')
    //                 dp[i][j]=dp[i-1][j] || dp[i][j-1];
    //             else
    //                 dp[i][j]=false;
    //         }
    //     }
    //     return dp[m][n];
    // }
}