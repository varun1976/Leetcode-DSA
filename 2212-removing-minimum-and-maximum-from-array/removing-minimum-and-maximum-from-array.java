class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int high=0,low=0;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
                high=i;
            }
            if(nums[i]<min){
                min=nums[i];
                low=i;
            }
        }
        System.out.println(low);
        System.out.println(high);
        int mid=n/2;

        int left=Math.max(low,high)+1;
        int right=n-Math.min(low,high);
        int both=(Math.min(low,high)+1)+(n-Math.max(low,high));
        return Math.min(left,Math.min(right,both));
        
    }
}