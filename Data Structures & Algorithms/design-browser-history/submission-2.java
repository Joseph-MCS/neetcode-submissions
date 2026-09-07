public class ListNode{
    String val; 
    ListNode next, prev; 

    ListNode( String val )
    {
        this.val = val; 
        this.next = null;
        this.prev = null;
    }

    ListNode( String val, ListNode prev, ListNode next )
    {
        this.val = val; 
        this.next = next; 
        this.prev = prev; 
    }
}

class BrowserHistory {

    ListNode curr; 

    public BrowserHistory(String homepage) 
    {
        curr = new ListNode(homepage, null, null);
    }
    
    public void visit(String url) {

        curr.next = new ListNode( url, curr, null );
        curr = curr.next;
        
    }
    
    public String back(int steps) {
        while ( steps > 0 && curr.prev != null )
        {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while ( steps > 0 && curr.next != null )
        {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */