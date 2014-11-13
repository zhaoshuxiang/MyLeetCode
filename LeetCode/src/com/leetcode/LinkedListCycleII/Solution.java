/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.LinkedListCycleII;

/**
 *
 * @author Shuxiang
 */
public class Solution {

    public static void main(String[] args) {
        int testData2[] = {1, 2, 3, 4, 5, 9, 10, 12 ,14};

        ListNode test2 = coverArrayToList(testData2);

//        output(test2);
        ListNode res = (new Solution()).detectCycle(test2);

        output(res);
    }

    public static ListNode coverArrayToList(int[] arr) {
        ListNode beginNode = null, endNode = null;

        for (int i = 0, len = arr.length; i < len; i++) {
            if (0 == i) {
                beginNode = new ListNode(arr[i]);
                endNode = beginNode;
            } else {
                endNode.next = new ListNode(arr[i]);
                endNode = endNode.next;
            }
        }

//        endNode.next = beginNode.next.next.next.next.next;

        return beginNode;
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

    public ListNode detectCycle(ListNode head) {
        ListNode slower = head, faster = head, cur = head;

        if (head == null) {
            return null;
        }

        int i = 0;
        while (null != faster && null != faster.next) {
            faster = faster.next.next;
            slower = slower.next;

            i = i + 1;

            if (faster == slower) {
                // 继续查找起始点
                while(true) {
                   if (cur == slower) {
                       return cur;
                   }
                   
                   cur = cur.next;
                   slower = slower.next;
                }
            }
        }

        return null;
    }

}
