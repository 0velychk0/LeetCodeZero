/**
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

package com.ovelychko;

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = new ListNode();
        ListNode iter = root;

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                iter.next = l2;
                l2 = null;
            } else if (l2 == null) {
                iter.next = l1;
                l1 = null;
            } else {
                if (l1.val > l2.val) {
                    iter.next = l2;
                    l2 = l2.next;
                } else {
                    iter.next = l1;
                    l1 = l1.next;
                }
                iter = iter.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(null, null));
    }
}
