package 알고리즘인터뷰.링크드리스트;

public class Add_Two_Numbers  {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = addTwo(l1,l2,0);
        return ret;
    }

    private ListNode addTwo(ListNode l1, ListNode l2, int add) {
        if(l1 == null && l2 == null) {
            if(add == 0) return null;
            else return new ListNode(1);
        }

        int a = 0;
        int b = 0;
        int sum = 0;
        int nextAdd = 0;
        ListNode nextL1,nextL2;

        if(l1 != null) {
            a= l1.val;
            nextL1 = l1.next;
        }
        else{
            nextL1 = null;
        }
        if(l2 != null){
            b= l2.val;
            nextL2 = l2.next;
        }
        else{
            nextL2 = null;
        }

        sum = a+b+add;
        if(sum >= 10) {
            sum -= 10;
            nextAdd = 1;
        }

        ListNode nowNode = new ListNode(sum);
        nowNode.next = addTwo(nextL1, nextL2, nextAdd);
        return nowNode;
    }
}