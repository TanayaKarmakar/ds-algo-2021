package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 15/06/23
 * @project ds-algo-2021-leetcode
 */
public class SortListLeetcode148 {
  private static ListNode sortList(ListNode head) {
    if(head == null || head.next == null)
      return head;
    ListNode mid = findMid(head);
    ListNode midNext = mid.next;
    mid.next = null;
    head = sortList(head);
    midNext = sortList(midNext);
    return merge(head, midNext);
  }

  private static ListNode merge(ListNode a, ListNode b) {
    if(a == null)
      return b;
    if(b == null)
      return a;
    ListNode result;
    if(a.val < b.val) {
      result = a;
      result.next = merge(a.next, b);
    } else {
      result = b;
      result.next = merge(a, b.next);
    }
    return result;
  }

  private static ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(4);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(3);

    ListNode ans = sortList(head);

    ListNode temp = ans;
    while(temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }
}
