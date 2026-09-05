class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int r2lMin[]=new int[n];
        r2lMin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            r2lMin[i]=Math.min(r2lMin[i+1],nums[i]);
        }
        int l2rMax=0;
        for(int i=0;i<n;i++){
            l2rMax=Math.max(l2rMax,nums[i]);
            if(l2rMax-r2lMin[i]<=k) return i;
        }
        return -1;

    }
}