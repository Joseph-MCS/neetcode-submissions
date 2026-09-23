public class ListNode{
    String url; 
    ListNode prev; 
    ListNode next; 

    public ListNode( String url )
    {
        this.url=url;
    }
}

class BrowserHistory {

    ListNode curr; 

    public BrowserHistory(String homepage) {

        ListNode page = new ListNode( homepage );
        this.curr=page;
        
    }
    
    public void visit(String url) {

        ListNode page = new ListNode( url );
        page.prev = curr;
        page.next = null;
        curr.next = page;
        curr = page; 
    
     
        
        
    }
    
    public String back(int steps) {

        while ( this.curr.prev != null && steps > 0 )
        {
            this.curr = this.curr.prev;
            steps--;
        }
        return this.curr.url;
        
    }
    
    public String forward(int steps) {

        while ( this.curr.next!=null && steps > 0 )
        {
            this.curr = this.curr.next;
            steps--;
        }
        return this.curr.url;

        
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */