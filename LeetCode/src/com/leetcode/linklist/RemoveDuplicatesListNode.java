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
public class RemoveDuplicatesListNode {

    public static void main(String[] args) {
        int testData[] = {1, 1, 2, 3, 3};
        
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

        ListNode res = (new RemoveDuplicatesListNode()).deleteDuplicates(beginNode);

        output(res);
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
    
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        
        ListNode cur = head, passNode = head, repeatNode = head;
        
        while(null != cur.next) {
            cur = cur.next;
            
            if (cur.val != passNode.val) {
                passNode.next = cur;
                passNode = cur;
            } else {
                if (cur.next == null) {
                    passNode.next = null;
                }
            }
        }
        
        return head;
    }

}
