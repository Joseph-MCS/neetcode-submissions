class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> differences = new HashMap<>();

        for ( int i = 0; i<nums.length; i++)
        {
            int difference = target - nums[i];
            if ( differences.containsKey(difference))
            {
                return new int[]{ differences.get(difference),i}; 
            }
            else
            {
                differences.put(nums[i],i);
            }
        }
        return new int[0];
        
    }
}
