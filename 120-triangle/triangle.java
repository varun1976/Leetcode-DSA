class Solution {
    public int f(int n,int i,int j,List<List<Integer>> triangle,Integer dp[][]){
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!=null) return dp[i][j];
        int down=triangle.get(i).get(j)+f(n,i+1,j,triangle,dp);
        int dia=triangle.get(i).get(j)+f(n,i+1,j+1,triangle,dp);
        return dp[i][j]=Math.min(down,dia);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer dp[][]=new Integer[n][n];
        return f(n,0,0,triangle,dp);
    }
    public int minimumTotalTabulation(List<List<Integer>> triangle) {
        int n=triangle.size();
        int prev[]=new int[n];
        for(int j=0;j<n;j++){
            prev[j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            int curr[]=new int[n];
            for(int j=i;j>=0;j--){
                int down=triangle.get(i).get(j)+prev[j];
                int dia=triangle.get(i).get(j)+prev[j+1];
                curr[j]=Math.min(down,dia);
            }
            prev=curr;
        }
        return prev[0];
    }
}