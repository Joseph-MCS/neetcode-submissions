class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int res = 0; 
        int cur = 0; 
        for ( int i = 0; i<nums.length; i++)
        {
            if ( nums[i] == 1) cur++;
            else
            {
                res = Math.max(cur,res);
                cur = 0; 
            }
            res = Math.max(cur,res);
        }
        return res;
        
    }
}