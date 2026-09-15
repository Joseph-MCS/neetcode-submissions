class Solution {
    public int search(int[] nums, int target) {

        int L = 0;
        int R = nums.length-1;
        int middle, res;

        while ( L <= R )
        {
            middle = L + ( R - L )/2;
            res = nums[middle];
            if ( res == target ) return middle; 
            else if ( res < target ) L = middle+1; 
            else R = middle-1;
        }
        return -1;

        
    }
}
