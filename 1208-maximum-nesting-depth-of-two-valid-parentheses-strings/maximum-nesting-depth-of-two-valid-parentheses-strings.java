class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth=0,i=0;
        int res[]=new int[seq.length()];
        for(char ch:seq.toCharArray()){
            if(ch=='(') depth++;
            res[i++]=depth%2;
            if(ch==')') depth--;
        }
        return res;
    }
}