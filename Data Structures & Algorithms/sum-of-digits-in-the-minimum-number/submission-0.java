class Solution {
    public int sumOfDigits(int[] nums) {

        int min = nums[0];
        for ( int val : nums )
        {
            min = Math.min(val,min);
        }
        String s = String.valueOf(min);
        int length = s.length();
        int sum = 0;
        for ( int i = 0; i<length; i++)
        {
            sum+=Integer.parseInt(s.substring(i,i+1));
        }
        return (sum%2==0? 1 : 0 );

    }
}
