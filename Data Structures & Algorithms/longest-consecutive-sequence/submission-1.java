class Solution {
    public int longestConsecutive(int[] nums) {

        if ( nums.length < 2 ) return nums.length;

        Set<Integer> numSet = new HashSet<>();

        int maxSequence = 0; 

        for ( int val : nums )
        {

            numSet.add(val);

        }


        for ( int num : numSet )
        {
            if ( !numSet.contains(num-1))
            {
                int currentNum = num;
                int sequence = 1; 
                while( numSet.contains(currentNum+1))
                {
                    sequence++;
                    currentNum++;
                }
                maxSequence = Math.max( sequence, maxSequence );
            }
            
        }
        return maxSequence;


       




       
    }
}
