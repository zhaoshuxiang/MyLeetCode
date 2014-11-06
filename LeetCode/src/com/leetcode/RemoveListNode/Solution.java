/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.RemoveListNode;

/**
 *
 * @author Shuxiang
 */
public class Solution {

    public static void main(String[] args) {
        int testData[] = {1, 2, 3, 4, 5};
        
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

        ListNode res = (new Solution()).removeNthFromEnd(beginNode, 11);

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        
        ListNode cur = head, end = null;
        int count = 1;
        
        while(null != cur.next) {
            count = count + 1;
            cur = cur.next;
        }
        
        ListNode last = null;
        
        n = n % count;
                
        if (0 == n) {
            n = count;
        }
        
        n = count - n;
        
        // 删除第一个
        if (0 == n) {
            return head.next;
        }
        
        cur = head;
        for(int i = 0; i < n; i++) {
            last = cur;
            cur = cur.next;
        }
        
        if (cur.next != null) {
            last.next = cur.next;
        } else {
            last.next = null;
        }
        
        return head;
    }

}
