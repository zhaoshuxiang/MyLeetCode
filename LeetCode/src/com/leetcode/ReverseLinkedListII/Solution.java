/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.ReverseLinkedListII;

/**
 *
 * @author Shuxiang
 */
public class Solution {

    public static void main(String[] args) {
        int testData[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
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

        ListNode res = (new Solution()).reverseBetween(beginNode, 4, 8);

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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head) {
            return null;
        }
        
        ListNode cur = head, preBegin = null, begin = null, end = null, endNext = null, tmp = null;
        int i = 1;
        while(null != cur) {
            
            if (1 == m) {
                begin = head;
            } else {
                if (i == m - 1) {
                    preBegin = cur;
                    begin = preBegin.next;
                } 
            }
            
            if(i == n) {
                end = cur;
                endNext = end;
            }

            cur = cur.next;
            i = i + 1;
        }
        
        if (1 != m) {
            preBegin.next = end;
        } else {
            head = end;
        }
        
        
        // 从end后追加插入节点
        while(begin != end) {
            
            tmp = begin.next;
            
            begin.next = endNext.next;
            endNext.next = begin;
            
            begin = tmp;
        }
        
        return head;
    }

}
