package com.leetcode.tree;

import com.leetcode.base.ListNode;

public class AddTwoNum {

    public static void main(String[] args) {
        int testDataA[] = {2, 4, 9, 9};
        int testDataB[] = {5, 6, 4, 9, 9};

        ListNode listNodeA = coverArrayToList(testDataA);
        ListNode listNodeB = coverArrayToList(testDataB);


        output(listNodeA);
        output(listNodeB);

	ListNode res = (new AddTwoNum()).addTwoNumbers(listNodeA, listNodeB);
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1Cur = l1, l2Cur = l2;
        ListNode res = null, end = null;
        boolean carry = false;
        int l1Val, l2Val, total, remainder;
        
        
        while (null != l1Cur || null != l2Cur || carry) {
            l1Val = 0;
            l2Val = 0;
            total = 0;
            remainder = 0;
            
            if (null != l1Cur) {
                l1Val = l1Cur.val;
                l1Cur = l1Cur.next;
            }
            
            if (null != l2Cur) {
                l2Val = l2Cur.val;
                l2Cur = l2Cur.next;
            }
            
            total = carry ? l1Val + l2Val + 1 : l1Val + l2Val;
            
            if (total >= 10) {
                remainder = total % 10;
                carry = true;
            } else {
                remainder = total;
                carry = false;
            }
            
            ListNode bitNode = new ListNode(remainder);
            
            if (null == res) {
                res = bitNode;
            } else {
                end.next = bitNode;
            }
            
            end = bitNode;
        }

        return res;
    }
}
