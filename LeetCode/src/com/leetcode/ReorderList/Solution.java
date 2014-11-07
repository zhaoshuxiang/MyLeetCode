/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.ReorderList;

/**
 *
 * @author Shuxiang
 */
public class Solution {

    public static void main(String[] args) {
        int testData[] = {1, 2, 3, 4};

        ListNode beginNode = null, endNode = null;
        for (int i = 0, len = testData.length; i < len; i++) {
            if (0 == i) {
                beginNode = new ListNode(testData[i]);
                endNode = beginNode;
            } else {
                endNode.next = new ListNode(testData[i]);
                endNode = endNode.next;
            }
        }

        output(beginNode);

        (new Solution()).reorderList(beginNode);

        output(beginNode);
    }

    public static void output(ListNode listNode) {
        if (listNode != null) {
            System.out.print(Integer.toString(listNode.val) + " ");

            if (null != listNode.next) {
                output(listNode.next);
            } else {
                System.out.println("");
            }
        } else {
            System.out.println("null");
        }
    }

    public void reorderList(ListNode head) {
        if (null == head) {
            return;
        }

        int count = count(head);

        if (count > 1) {
            int num = (int) Math.ceil((double) count / 2);

            ListNode needReverse = findByIndex(head, num - 1);

            ListNode partTwo = reserved(needReverse.next);
            needReverse.next = null;

            merge(head, partTwo);
        }

    }

    public ListNode reserved(ListNode head) {
        int count = count(head);
        ListNode end = findByIndex(head, count - 1);
        ListNode cur = head, tmp = null;

        while (cur != end) {
            if (null == end.next) {
                end.next = cur;
                head = cur.next;

                cur.next = null;
                cur = head;
            } else {
                tmp = end.next;
                end.next = cur;
                head = cur.next;

                cur.next = tmp;
                cur = head;
            }
        }

        return head;
    }

    public void merge(ListNode partOne, ListNode partTwo) {
        ListNode partOneCur = partOne;
        ListNode partTwoCur = partTwo;
        ListNode tmp = null;

        while (null != partTwoCur) {
            tmp = partOneCur.next;
            partOneCur.next = partTwoCur;
            partTwoCur = partTwoCur.next;
            partOneCur.next.next = tmp;
            partOneCur = partOneCur.next.next;
        }
    }

    public int count(ListNode head) {
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            count = count + 1;
            cur = cur.next;
        }

        return count;
    }

    public ListNode findByIndex(ListNode head, int index) {
        int i = 1;
        ListNode cur = head;

        while (i <= index) {
            i = i + 1;
            cur = cur.next;
        }

        return cur;
    }

}
