class Solution {
    public double help(double x,long n){
        if(n==0) return 1;
        if(n==1) return x;
        if(n==2) return x*x;
        double half=help(x,n/2);
        return half*half*help(x,n%2);
    }
    public double myPow(double x, int n) {
        if(n>0) return help(x,n);
         return 1/help(x,-(long)n);
    }
}