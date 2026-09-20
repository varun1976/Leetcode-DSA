class Solution {
    public int reverseDegree(String s) {
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
            res+=(26-(s.charAt(i)-'a'))*(i+1);
        }
        return res;
    }
}