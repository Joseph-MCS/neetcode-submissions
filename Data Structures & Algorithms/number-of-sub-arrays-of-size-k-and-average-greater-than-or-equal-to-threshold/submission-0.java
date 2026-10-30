class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0; 
        int L = 0;
        int sum; 
        for ( int R = k-1;R<arr.length;R++)
        {
            sum = 0; 
            for ( int i = L; i<L+k; i++)
            {
                sum+=arr[i];
            }
            if ( sum/k >= threshold ) res++;
            L++;
        }
        return res;
        
    }
}