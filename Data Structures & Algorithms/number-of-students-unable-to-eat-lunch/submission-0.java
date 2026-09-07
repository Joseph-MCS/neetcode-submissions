class Solution {
    public int countStudents(int[] students, int[] sandwiches) 
    {

        Deque<Integer> queueStudents = new ArrayDeque<>();
        for ( int i = 0; i < students.length; i++ )
        {
            queueStudents.offer(students[i]);
        }
        Deque<Integer> stackSandwiches = new ArrayDeque<>();
        for ( int i = sandwiches.length-1; i>=0; i--)
        {
            stackSandwiches.push(sandwiches[i]);
        }

        int rotations = 0; 
        while ( !queueStudents.isEmpty() && rotations<queueStudents.size() )
        {
            if ( queueStudents.peek()==stackSandwiches.peek() )
            {
                stackSandwiches.pop();
                queueStudents.poll();
                rotations = 0; 
            }
            else
            {
                queueStudents.offer(queueStudents.poll());
                rotations++;
            }
        }
        return queueStudents.size();
       
    }
}