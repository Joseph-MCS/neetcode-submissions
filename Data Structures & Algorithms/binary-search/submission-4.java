class Solution {
    public int search(int[] nums, int target) {

        return binarySearch( nums, target, 0, nums.length-1 );
        
    }

    public int binarySearch( int[] nums, int target, int left, int right )
    {
          if ( left > right ) return -1;
          int middle = left + ( right - left )/ 2;
          int middleVal = nums[middle];
          if ( middleVal == target ) return middle; 
          else 
          {
               return ( target > middleVal ?
               binarySearch(nums,target,middle+1,right)
               : binarySearch(nums,target,left,middle-1) );
            
          }
    }
}
