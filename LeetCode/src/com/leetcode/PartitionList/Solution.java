/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.PartitionList;

/**
 *
 * @author Shuxiang
 */
public class Solution {

    public static void main(String[] args) {
        int testData[] = {4, 1, 3, 2, 5, 2};

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

        ListNode res = (new Solution()).partition(beginNode, 100);

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

    public ListNode partition(ListNode head, int x) {
        if (null == head) {
            return null;
        }

        ListNode cur = head, last = null, smallCur = null, needMove = null, tmp = null;
        while (null != cur) {
            if (cur.val < x) {
                // 如果不是第一个元素
                if (cur != head) {
                    if (null == smallCur) {
                        // 换位元素
                        needMove = cur;
                        last.next = cur.next;
                        cur = cur.next;

                        needMove.next = head;
                        smallCur = needMove;
                        head = needMove;
                    } else {
                        // 换位元素
                        if (smallCur.next == cur) {
                            smallCur = cur;
                            cur = cur.next;
                        } else {
                            needMove = cur;
                            last.next = cur.next;
                            cur = cur.next;

                            tmp = smallCur.next;
                            smallCur.next = needMove;
                            needMove.next = tmp;
                            smallCur = needMove;
                        }

                    }
                } else {
                    last = cur;
                    smallCur = cur;
                    cur = cur.next;
                }
            } else {
                last = cur;
                cur = cur.next;
            }
        }

        return head;
    }

}
