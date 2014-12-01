package com.leetcode.linklist;

import com.leetcode.base.ListNode;

public class RotatList {
	
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
		
		ListNode res = (new RotatList()).rotateRight(null, 1);
		
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

	public ListNode rotateRight(ListNode head, int n) {
		int num = 1;
		ListNode cur = head;
		ListNode tmp;
		
		int p = 1;
		
		if (0 == n || null == head) {
			return head;
		}

		while (cur.next != null) {
			num = num + 1;
			cur = cur.next;
		}
		
		cur.next = head;
		
		n = n % num;
		n = num - n;
		
		while (true) {
			if (n == p) {
				tmp = head.next;
				head.next = null;
				return tmp;
			}
			
			p = p + 1;
			head = head.next;
		}
	}
}
