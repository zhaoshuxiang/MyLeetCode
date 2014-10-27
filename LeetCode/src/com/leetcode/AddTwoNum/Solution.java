package com.leetcode.AddTwoNum;

public class Solution {
	
	public static void main(String[] args) {
		int testDataA[] = {1, 2, 3, 4, 5};
		int testDataB[] = {5, 4, 3, 2, 1};
		
		ListNode listNodeA = null, listNodeB = null;
		ListNode curNodeA = null, curNodeB = null;
		
		for (int i = 0, len = testDataA.length; i < len; i++) {
			if (0 == i) {
				listNodeA = new ListNode(testDataA[i]);
				listNodeB = new ListNode(testDataB[i]);
				
				curNodeA = listNodeA;
				curNodeB = listNodeB;
			} else {
				curNodeA.next = new ListNode(testDataA[i]);
				curNodeB.next = new ListNode(testDataB[i]);
				
				curNodeA = curNodeA.next;
				curNodeB = curNodeB.next;
			}
		}
		
		output(listNodeA);
		output(listNodeB);
		
//		ListNode res = (new Solution()).addTwoNumbers(listNodeA, listNodeB);
		
//		output(res);
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
        
    	return new ListNode(0);
    }
}
