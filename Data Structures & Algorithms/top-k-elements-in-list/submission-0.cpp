class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {

        // count[value] = how many times that value appears in nums
        unordered_map<int,int> count;

        // Bucket array. freq[f] will hold every value that appears exactly f times.
        // Sized nums.size()+1 because a value can appear at most nums.size() times,
        // so we need indices 0..nums.size().
        vector<vector<int>> freq(nums.size()+1);

        for ( int n : nums )
        {
            // count[n] defaults to 0 if n was never seen before, so this is count[n] += 1.
            // n is the VALUE from the array; count[n] is its frequency.
            count[n] = 1 + count[n];
        }

        for ( const auto& entry : count )
        {
            // entry is one pair from the map: entry.first = the value, entry.second = its frequency.
            // We index the bucket by frequency and store the value in it.
            // So freq[3] ends up holding every value that appeared exactly 3 times.
            freq[entry.second].push_back(entry.first);
        }

        vector<int> res;

        // Walk buckets from most frequent down to least frequent.
        // Stop at i > 0, not i >= 0, because bucket 0 is always empty
        // (no value can appear zero times).
        for ( int i = freq.size() - 1; i>0; --i)
        {
            // Every value in this bucket has the same frequency, i.
            // We don't care about ordering within a bucket; any k of them is a valid answer.
            for ( int n : freq[i])
            {
                res.push_back(n);

                // As soon as we've collected k values, we're done.
                if ( res.size()==k)
                {
                    return res;
                }
            }
        }

        // Only reached if k was larger than the number of distinct values.
        return res;
    }
};