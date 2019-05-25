package wang.study.leetcode;

public class SwapNodesInpairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode head0 = new ListNode(-1);
        head0.next = head;
        ListNode p = head0, q;
        while (p.next != null && p.next.next != null) {
            q = p.next.next;
            p.next.next = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
        }
        return head0.next;
    }
}
