/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcodeRemoveDuplicatesListNodeII;

/**
 *
 * @author Shuxiang
 */
public class Solution {

    public static void main(String[] args) {
        int testData[] = {1, 3, 3, 3, 3, 3};
        
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

        ListNode res = (new Solution()).deleteDuplicates(beginNode);

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
        
        ListNode cur = head, passNode = head, lastPassNode = head;
        boolean isRepeat = false;
        
        while(null != cur.next) {
            cur = cur.next;
            
            if (cur.val != passNode.val) {
                // 如果链表的第一个元素是重复的
                if (isRepeat && passNode == head) {
                    head = cur;
                    passNode = cur;
                    lastPassNode = cur;
                } else {
                    
                    if (isRepeat) {
                        lastPassNode.next = cur;
                    } else {
                        // passNode 这个元素不重复
                        if (passNode != lastPassNode) {
                            lastPassNode = passNode;
                        }
                    }
                    
                    passNode = cur;
                }

                isRepeat = false;
            } else {
                if (cur.next == null) {
                    if (passNode == head && head == lastPassNode) {
                        return null;
                    } else {
                        lastPassNode.next = null;
                    }
                    
                }
                
                isRepeat = true;
            }
        }
        
        return head;
    }

}
