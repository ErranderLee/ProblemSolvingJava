package problem.leetcode;

/**
 * Definition for singly-linked list.
 */
class ListNode2 {
     int val;
     ListNode2 next;
     ListNode2() {}
     ListNode2(int val) { this.val = val; }
     ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}
public class AddTwoNumbers {
    public ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        int temp = 0;
        int overTen = 0;
        ListNode2 answer = new ListNode2();
        ListNode2 pos = answer;
        temp = l1.val + l2.val;
        if (temp >= 10) {
            answer.val = temp - 10;
            overTen = 1;
        } else {
            answer.val = temp;
        }
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + overTen;
            overTen = 0;
            if (temp >= 10) {
                overTen = 1;
                temp -= 10;
            }
            pos.next = new ListNode2(temp);
            pos = pos.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            temp = l1.val + overTen;
            if (temp >= 10) {
                temp -= 10;
                overTen = 1;
            } else {
                overTen = 0;
            }
            pos.next = new ListNode2(temp);
            pos = pos.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            temp = l2.val + overTen;
            if (temp >= 10) {
                temp -= 10;
                overTen = 1;
            } else {
                overTen = 0;
            }
            pos.next = new ListNode2(temp);
            pos = pos.next;
            l2 = l2.next;
        }

        if (overTen == 1) {
            pos.next = new ListNode2(1);
        }

        return answer;
    }
}
