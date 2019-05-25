package wang.study.leetcode;

public class RemoveNthNodeFromEndofList {
    // set the head node first then solution the problem
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head0 = new ListNode(-1);
        head0.next = head;
        ListNode p = head0, q = head0;
        while (n-- > 0) q = q.next;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head0.next;
    }
}
