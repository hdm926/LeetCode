public class add_two_node_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;//进位
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null){
            int num1 = (l1 == null)? 0 : l1.val;
            int num2 = (l2 == null)? 0 : l2.val;
            int sum = num1 + num2 + flag;

            if(head == null){
                head = new ListNode(sum % 10);
                tail = head;
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            flag = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(flag > 0){
            tail.next = new ListNode(flag);
            tail = tail.next;
        }
        return head;
    }
}

