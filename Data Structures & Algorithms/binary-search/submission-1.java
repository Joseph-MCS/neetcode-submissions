class Solution {
    public int search(int[] nums, int target) {

        int l = 0; 
        int r = nums.length-1;   
        while ( l <= r )
        {

            int middle = l + ( r - l )/2;
            if ( nums[middle] == target ) return middle;
            else if ( nums[middle] > target )
            {   
                r = middle-1;
            }
            else
            {
                l = middle+1;
            }
        }
        return -1; 
    }
}
