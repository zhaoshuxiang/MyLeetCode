package com.leetcode.SortList;

public class Solution {
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(4);
		ListNode listNode2 = new ListNode(5);
		ListNode listNode3 = new ListNode(2);
		ListNode listNode4 = new ListNode(1);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		
//		output(listNode1);
		
		Solution s = new Solution();
		s.sortList(listNode1);
	}
	
	public static void output(ListNode listNode) {
		if (listNode != null) {
			System.out.print(Integer.toString(listNode.val) + " ");

			if (null != listNode.next) {
				output(listNode.next);
			}
		}
	}
	
	public ListNode sortList(ListNode head) {
		ListNode selNode = head;
		ListNode curNode = head.next;
		ListNode smallList = null, biggerList = null;
		
		ListNode temp = null;
		
		while(curNode != null) {
			temp = curNode.next;
			curNode.next = null;
			if (curNode.val < selNode.val) {
				if  (null == smallList) {
					smallList = curNode;
				} else {
					this.append(smallList, curNode);
				}
			} else {
				if  (null == biggerList) {
					biggerList = curNode;
				} else {
					this.append(biggerList, curNode);
				}
			}
			
			curNode = temp;
		}
		
		output(smallList);
		
		output(biggerList);
		
		if (smallList != null) {			
			smallList = this.sortList(smallList);
		}
		
		if (biggerList != null) {			
			biggerList = this.sortList(biggerList);
		}
		
		this.append(smallList, selNode);
		this.append(smallList, biggerList);
		
		return smallList;
	}
	
	public void append(ListNode head, ListNode nodeList) {
		ListNode lastNode = head;
		
		if (head != null) {
			
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			
			lastNode.next = nodeList;
		}
	}
}
