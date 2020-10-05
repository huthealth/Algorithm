package 알고리즘인터뷰.링크드리스트;

public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        groupOdd(head.next,2,head,head);
        return head;
    }

    private void groupOdd(ListNode now, int index, ListNode prev, ListNode lastOdd ){
        if(now == null) return;
        if(index %2 == 0) {
            groupOdd(now.next,index+1,now,lastOdd);
            return;
        }

        ListNode lastNext = lastOdd.next;
        ListNode next = now.next;
        lastOdd.next = now;
        now.next = lastNext;
        prev.next = next;
        groupOdd(next,index+1,prev,now);
    }
}