/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.MergeTwoSortedLists;

import com.leetcode.base.ListNode;

/**
 *
 * @author Shuxiang
 */
public class Solution {

    public static void main(String[] args) {
        int testData1[] = {8};
        int testData2[] = {1, 3, 5, 10};
        
        ListNode test1 = coverArrayToList(testData1);
        ListNode test2 = coverArrayToList(testData2);

        output(test1);
        output(test2);

        ListNode res = (new Solution()).mergeTwoLists(test1, test2);

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (null == l1 && null == l2) {
            return null;
        }

        if (null == l1 && null != l2) {
            return l2;
        }
        
        if (null != l1 && null == l2) {
            return l1;
        }
        
        ListNode tmp = null;
        ListNode l1Cur = l1, l2Cur = l2;
        
        while (l2Cur != null) {
            while(l1Cur.next != null && l1Cur.val < l2Cur.val && l1Cur.next.val < l2Cur.val) {
                l1Cur = l1Cur.next;
            }
            
            // 如果是第一个节点
            if (l1Cur == l1 && l1Cur.val > l2Cur.val) {
                tmp = l2Cur.next;
                l2Cur.next = l1;

                l1 = l2Cur;
                l1Cur = l2Cur;

                l2Cur = tmp;
            } else {
                tmp = l1Cur.next;
                l1Cur.next = l2Cur;
                l2 = l2Cur.next;
                l2Cur.next = tmp;
                
                l2Cur = l2;
            }
            
//            output(l1);
        }
        
        // 最后一个元素

        return l1;
    }

}
