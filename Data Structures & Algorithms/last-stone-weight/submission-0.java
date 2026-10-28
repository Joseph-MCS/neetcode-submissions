class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int smashed;
        for ( int i = 0; i < stones.length; i++ )
        {

            maxHeap.add(stones[i]);

        }
        while( maxHeap.size() > 1 )
        {
            smashed = Math.abs(maxHeap.poll()-maxHeap.poll());
            if ( smashed == 0 ) continue;
            else 
            {
                maxHeap.add(smashed);
            }
        }
        return ( maxHeap.size() == 0 ? 0 : maxHeap.poll());
        
    }
}
