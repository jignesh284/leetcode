class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode prev = result;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            int l1_val = 0;
            int l2_val = 0;
            int sum = 0;
            if(l1 != null) {
                l1_val = l1.val;
                l1 = l1.next;
            } 
            if(l2 != null) {
                l2_val = l2.val;
                l2 = l2.next;
            } 
            prev.next = new ListNode((l1_val + l2_val + carry)%10);
            carry = (l1_val + l2_val + carry)/10;
            prev = prev.next;
        }
        return result.next;
    }
}
