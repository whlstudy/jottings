package wang.study.leetcode;

import org.junit.Test;

public class MergeKSortedList {
    /**
     * merge k sorted list
     *
     * solution: merge every two sorted list to one sorted list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int len = lists.length;
        if(len == 1) return lists[0];
        while(len != 1){
            int start = 0;
            int end = len-1;
            while(start<end){
                mergeTwoSortedList(start,end,lists);
                start++;
                end--;
            }
            len = end+1;
        }
        return lists[0];
    }



    private void mergeTwoSortedList(int start,int end,ListNode[] lists) {
        if(lists[start] == null){
            lists[start] = lists[end];
            return;
        }
        ListNode head = new ListNode(-1);
        head.next = lists[start];
        ListNode p = head;
        ListNode q = lists[end];
        while (q != null && p.next != null){
            if(p.next.val > q.val){
                ListNode tmp = q;
                q = q.next;
                tmp.next = p.next;
                p.next = tmp;
                p = p.next;
            }else {
                p = p.next;
            }
        }
        if (q != null) p.next = q;
        lists[start] = head.next;
    }

    @Test
    public void test(){
        ListNode l10 = new ListNode(1);
        //ListNode l12 = new ListNode(4);
        //l10.next = l12;
        //ListNode l13 = new ListNode(5);
        //l12.next = l13;

        ListNode l20 = new ListNode(0);
        //ListNode l22 = new ListNode(3);
        //l20.next = l22;
        //ListNode l23 = new ListNode(4);
        //l22.next = l23;

        ListNode l30 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l30.next = l32;
        //ListNode l33 = new ListNode(7);
        //l32.next = l33;

        ListNode[] arr = new ListNode[]{l10,l20};
        ListNode ret = mergeKLists(arr);

        //System.out.println(ret);
    }
}
