class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        if ( nums.length == 1 ) return 1;

        int res = 1; 
        int max = -1;
        boolean increasing = true; 
        if ( nums[0] > nums[1] ) increasing = false;
        for ( int i = 1; i<nums.length; i++)
        {
            if ( nums[i]==nums[i-1])
            {
                max = Math.max(res,max);
                res = 1;
                continue;
            }
            if ( ( increasing ? nums[i]>nums[i-1] : nums[i-1] > nums[i] ) )res++;
            else
            { 
            increasing = !increasing;
            max = Math.max(res,max);
            res=2;
            } 
        }
        return Math.max(res,max);
        
    }
}