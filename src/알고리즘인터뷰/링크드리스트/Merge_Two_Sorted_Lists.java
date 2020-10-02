package 알고리즘인터뷰.링크드리스트;


public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = mtl(l1,l2);
        return head;

    }
    public ListNode mtl(ListNode l1,ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 != null && l2 == null) {
            ListNode node = new ListNode(l1.val);
            l1 = l1.next;
            ListNode now = node;
            while(l1 != null){
                now.next = new ListNode(l1.val);
                now = now.next;
                l1 = l1.next;
            }
            return node;
        }
        if(l1 == null && l2 != null){
            ListNode node = new ListNode(l2.val);
            l2 = l2.next;
            ListNode now = node;
            while(l2 != null){
                now.next = new ListNode(l2.val);
                now = now.next;
                l2 = l2.next;
            }
            return node;
        }

        ListNode node = null;
        int val1 = l1.val;
        int val2 = l2.val;
        if(val1 > val2) {
            node = new ListNode(val2);
            node.next = mtl(l1,l2.next);
        }
        else {
            node = new ListNode(val1);
            node.next = mtl(l1.next,l2);
        }
        return node;
    }

}