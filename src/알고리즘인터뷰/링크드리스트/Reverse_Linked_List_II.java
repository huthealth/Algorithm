package 알고리즘인터뷰.링크드리스트;

public class Reverse_Linked_List_II {

    int m;
    int n;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.m = m;
        this.n = n;

        return reverse(head,1);

    }

    private ListNode reverse(ListNode now, int index){

        if(index < m) {
            now.next = reverse(now.next, index+1);
            return now;
        }

        ListNode nowHead = now;
        while(index < n) {
            ListNode prev = now.next;
            ListNode next = now.next.next;
            prev.next = nowHead;
            now.next = next;
            nowHead = prev;
            index++;
        }
        return nowHead;
    }
}