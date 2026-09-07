public class ListNode{
    ListNode next,prev;
    int val;
    ListNode( int val )
    {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
    ListNode(int val,ListNode prev, ListNode next)
    {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class Deque {

    ListNode head, tail;

    public Deque() 
    {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {

        if ( head == null ) return true;
        else return false;

    }

    public void append(int value) {

        if ( isEmpty() )
        {
            appendFirst(value);
            return;
        }
        else
        {
            ListNode newNode = new ListNode(value,tail,null);
            tail.next = newNode; 
            tail = newNode;
            return;
        }

       
    }

    public void appendleft(int value) 
    {
        if ( isEmpty() )
        {
            appendFirst(value);
            return;
        }
        else
        {
            ListNode newNode = new ListNode(value,null,head);
            head.prev = newNode;
            head = newNode;
            return;
        }
        
    }

    public void appendFirst(int value)
    {
        ListNode newNode = new ListNode(value);
        head = newNode; 
        tail = newNode; 
        return;
    }

    public int pop() {

        if ( isEmpty() )
        {
            return -1;
        }
        else
        {
            int val = tail.val;
            if ( tail.prev == null )
            {
                head = null;
                tail = null;
            }
            else
            {
                tail.prev.next = null;
                tail = tail.prev;
            }
            return val;

        }

        
    }

    public int popleft() 
    {

         if ( isEmpty() )
        {
            return -1;
        }
        else
        {
            int val = head.val;
            if ( head.next == null )
            {
                head = null;
                tail = null;
            }
            else
            {
                head.next.prev = null;
                head = head.next;
 
            }
            return val;
        }
     
    }
}
