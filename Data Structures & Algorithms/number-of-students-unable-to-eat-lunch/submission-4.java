class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int n = students.length;
        int res = n; 
        int[] cnt = new int[2]; 

        /// cnt array -> the preferences of the students
        /// res : result initialised to the number of students 

        for ( int i = 0; i<n; i++ )
        {
            cnt[students[i]]++;
        }

        for ( int i = 0; i<n; i++ )
        {
            // sandwiches must either be 1 or 0 indicating the type of sandiwch
            if ( cnt[sandwiches[i]] > 0 )
            {
                res--;
                cnt[sandwiches[i]]--;
                // if we have more than 0 sandwiches of the type indicated by i, 
                // we can feed a student with that sandiwch 
                
            }
            else{
                break;
            }
         
        }

        return res;

        
    }
}