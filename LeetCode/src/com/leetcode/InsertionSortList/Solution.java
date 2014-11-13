/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.InsertionSortList;

/**
 *
 * @author Shuxiang
 */
public class Solution {

    public static void main(String[] args) {
//        int testData[] = {4, 1, 3, 2, 8, 7 ,6, 5};
        int testData[] = {3, 2, 1};

        ListNode test = coverArrayToList(testData);

        output(test);
        ListNode res = (new Solution()).insertionSortList(test);
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

    public ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        
        ListNode tag = head.next;
        // 已排好顺序的部分链表
        ListNode begin = head, end = head;

        while (null != tag) {

            if (tag.val >= end.val) {
                end = tag;
                tag = tag.next;
            } else {
                // 从来链表中移除标记的节点
                end.next = tag.next;
                tag.next = null;

                ListNode cur = begin, curPre = begin;
                // 将标记的节点插入已排好序的链表中
                while (cur != end.next) {
                    if (tag.val < cur.val) {
                        if (cur == begin) {
                            tag.next = begin;
                            begin = tag;
                        } else {
                            curPre.next = tag;
                            tag.next = cur;
                        }
                        
                        break;
                    } else {
                        curPre= cur;
                        cur = cur.next;
                    }
                }
                
                tag = end.next;
            }
        }

        return begin;
    }

}
