package problem;

import java.util.*;

// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    while (head.val != 100001) {
      if (head.next == null) {
        return false;
      }
      head.val = 100001;
      head = head.next;
    }
    return true;
  }

  public ListNode detectCycle(ListNode head) {
    if (head == null) return null;
    while (head.val != 100001) {
      if (head.next == null) return null;
      head.val = 100001;
      head = head.next;
    }
    return head;
  }
}
