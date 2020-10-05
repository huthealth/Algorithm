package 알고리즘인터뷰.링크드리스트;


public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        return swapNode(head);

    }

    private ListNode swapNode(ListNode now) {
        if(now == null || now.next == null) return now;

        ListNode prev = now.next;
        ListNode next = now.next.next;
        //now.next = next;
        prev.next = now;
        now.next = swapNode(next);
        return prev;
    }
}