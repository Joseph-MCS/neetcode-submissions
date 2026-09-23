class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int[] count = new int[2];
        int res = students.length;

        for ( int i = 0; i<students.length; i++ )
        {
            count[students[i]]++;
        }

        for ( int i = 0; i<sandwiches.length; i++ )
        {
            if ( count[sandwiches[i]] > 0 )
            {
                count[sandwiches[i]]--;
                res--;
            }
            else{
                break;
            }
        }
        return res;


        
    }
}