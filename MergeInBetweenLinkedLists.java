class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l2_end = list2;
        while(l2_end.next != null) {
            l2_end = l2_end.next;
        }
        int node_count = 0;
        ListNode itr = list1;
        
        
        while(node_count < b ) {
            if(node_count == a-1) {
                ListNode temp = itr.next;
                itr.next = list2;
                itr = temp;
            } else {
                itr = itr.next;
                
            }
            node_count++;
        }
        
       l2_end.next = itr.next;
       return list1;
    }
}
