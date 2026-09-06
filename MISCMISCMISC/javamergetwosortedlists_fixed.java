// Fixed implementation kept separate so your original file is unchanged.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class javamergetwosortedlists_fixed {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null)
        {
            if (list1.val < list2.val) 
            {
                tail.next = list1;
                list1 = list1.next;
            } 
            else 
            {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        // append whichever list still has nodes
        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    // Small test harness
    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode b = new ListNode(2, new ListNode(4));
        ListNode r = mergeTwoLists(a, b);
        printList(r);
    }

    private static void printList(ListNode n) {
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.val);
            if (n.next != null) sb.append(" -> ");
            n = n.next;
        }
        System.out.println(sb.toString());
    }
}
