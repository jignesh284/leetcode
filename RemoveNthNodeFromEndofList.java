class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode myList = new ListNode(0, head); // I like adding a extra node on the top of the list to have easier boundary conditions
        ListNode nth = myList;
        ListNode last = head;
        
        for(int i=0; i<n-1; i++) {
            if(last != null) {
                last = last.next;
            }
        }
        
        while(last.next != null ) {
            last = last.next;
            nth = nth.next;
        }
        
        nth.next = nth.next.next;
        
        return myList.next;
        
    }
}
