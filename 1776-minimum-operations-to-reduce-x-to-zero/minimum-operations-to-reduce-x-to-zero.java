class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int num:nums) sum+=num;

        int target=sum-x;
        int maxi=-1;
        int l=0,r=0;
        sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>target && l<nums.length){
                sum-=nums[l];
                l++;
            }
            if(sum==target) maxi=Math.max(maxi,r-l+1);
            r++;
        }
        if(maxi==-1) return -1;
        return nums.length-maxi;
    }
}