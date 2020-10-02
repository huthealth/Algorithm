package 알고리즘인터뷰.링크드리스트;

import java.util.ArrayList;
import java.util.List;

class ListNode {
     int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public class Palindrome_Linked_List {

    List<Integer> list = new ArrayList<>();
    public boolean isPalindrome(ListNode head) {
        getNum(head);
        int n = list.size();
        for(int i = 0 ; i < n/2 ; i++) {
            int num1 = list.get(i);
            int num2 = list.get(n-1-i);
            System.out.println(list.get(i) + "  "+ list.get(n-1-i));
            if(list.get(i).equals( list.get(n-1-i))){
                return false;
            }
        }

        return true;
    }

    public void getNum(ListNode node) {
        if(node == null) return;
        System.out.println(node.val);
        list.add(node.val);
        getNum(node.next);
    }
}
