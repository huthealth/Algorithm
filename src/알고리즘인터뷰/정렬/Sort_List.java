package 알고리즘인터뷰.정렬;

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Sort_List {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode ret = null;
        ListNode prev =null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        ret = merge(list1,list2);
        return ret;

    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode tempList = new ListNode(0);
        ListNode pointer = tempList;

        while(list1 != null && list2 != null) {
            if(list1.val > list2.val){
                pointer.next = list2;
                list2 = list2.next;
            }
            else{
                pointer.next = list1;
                list1=  list1.next;
            }
            pointer = pointer.next;
        }
        if(list1 != null) pointer.next = list1;
        else pointer.next = list2;

        return tempList.next;
    }
}