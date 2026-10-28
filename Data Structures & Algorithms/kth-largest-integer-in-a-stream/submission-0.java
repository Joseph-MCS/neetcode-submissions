class KthLargest {

    int k;
    PriorityQueue<Integer> maxPQ;

    public KthLargest(int k, int[] nums) 
    {
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        this.k=k;
        for ( int i = 0; i<nums.length; i++)
        {
            maxPQ.add(nums[i]);
        }
    }
    
    public int add(int val) 
    {
        maxPQ.add(val);
        Stack<Integer> temp = new Stack<>();
        for ( int i = 0; i<k-1; i++)
        {
            temp.push(maxPQ.poll());
        }
        int res = maxPQ.peek();
        while ( !temp.isEmpty())
        {
            maxPQ.add(temp.pop());
        }
        return res;
    }
}
