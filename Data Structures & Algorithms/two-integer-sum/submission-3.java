class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> difference = new HashMap<>();
        int num;
        for ( int i = 0; i<nums.length; i++ )
        {
            num = nums[i];
            if ( difference.containsKey( target - num ) ) 
            {
            return new int[]{ difference.get(target - num), i};
            }
            else difference.put(num, i );
        }
        return new int[0];
        
    }
}
