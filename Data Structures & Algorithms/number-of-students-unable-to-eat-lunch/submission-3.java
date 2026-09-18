class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

         Stack<Integer> sandwichStack = new Stack<>();
         Deque<Integer> studentQueue = new ArrayDeque<>();
         for ( int i = sandwiches.length-1; i >= 0; i-- )
         {
            sandwichStack.push(sandwiches[i]);
         }
         for ( int i = 0; i<students.length; i++ )
        {

            studentQueue.offer(students[i]);

        }

        int numPolls = 0, studentPref; 
        while ( numPolls <= sandwichStack.size() && !studentQueue.isEmpty() )
        {
            studentPref = studentQueue.poll();
            if ( studentPref == sandwichStack.peek() )
            {
                numPolls = 0;
                sandwichStack.pop();
            }
            else 
            {
                numPolls++;
                studentQueue.offer(studentPref);
            }
        }

        return studentQueue.size();
        
    }
}