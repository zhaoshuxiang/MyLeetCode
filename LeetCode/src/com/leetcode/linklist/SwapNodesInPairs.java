package com.leetcode.linklist;

import com.leetcode.base.ListNode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        int testDataA[] = {1, 2, 3, 4, 5, 7};

        ListNode listNodeA = coverArrayToList(testDataA);

        output(listNodeA);
	ListNode res = (new SwapNodesInPairs()).swapPairs(listNodeA);
        output(res);
    }
    
    
    public static ListNode  coverArrayToList(int[] arr) {
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

    public ListNode swapPairs(ListNode head) {
        ListNode fPin = head, sPin = null, curPin = head;
        
        if (null == head) {
            return head;
        }
        
        if (null != fPin.next) {
            sPin = fPin.next;
        }
        
        while(null != sPin) {
            // 交换
            if (fPin == head) {
                fPin.next = sPin.next;
                sPin.next = fPin;
                head = sPin;
            } else {
                fPin.next = sPin.next;
                curPin.next = sPin;
                sPin.next = fPin;
                curPin = fPin;
            }
            
            // 指针向前走
            if (null != fPin.next && null != fPin.next.next) {
                fPin = fPin.next;
                sPin = sPin.next.next.next;
            } else {
                sPin = null;
            }
        }
        
        return head;
    }
}
