/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.linklist;

import com.leetcode.base.ListNode;

/**
 *
 * @author Shuxiang
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        int testData2[] = {1};
        
        ListNode test2 = coverArrayToList(testData2);

//        output(test2);

        boolean res = (new LinkedListCycle()).hasCycle(test2);

        System.out.print(res);
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
        
        endNode.next = beginNode;

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

    public boolean hasCycle(ListNode head) {
        ListNode slower = head, faster = head;
        
        if (head == null) {
            return false;
        }
        
        while(null != faster){
            if (null != faster.next) {
                faster = faster.next.next;
                slower = slower.next;
                
                if (faster == slower) {
                    return true;
                }
            } else {
                return false;
            }
        }
        
        return false;
    }

}
