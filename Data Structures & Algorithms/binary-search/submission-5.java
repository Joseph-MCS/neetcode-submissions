class Solution {
    public int search(int[] nums, int target) {
        

        int left = 0; 
        int right = nums.length-1;
        int mid; 
        int element;

        while ( left <= right )
        {

            mid = left + ( right - left )/2;
            element = nums[mid];
            if ( element == target ) return mid; 
            else if ( target > element )
            {

                left = mid+1;

            }
            else 
            {

                right = mid-1;

            }

        }
        return -1;
        
    }
}
