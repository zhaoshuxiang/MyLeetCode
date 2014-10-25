package com.leetcode.SortList;

public class Solution {

	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(5);
		ListNode listNode2 = new ListNode(5);
		ListNode listNode3 = new ListNode(2);
		ListNode listNode4 = new ListNode(8);
		ListNode listNode5 = new ListNode(6);

		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;

		// output(listNode1);

		Solution s = new Solution();
		s.sortList(listNode1);
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

	public ListNode sortList(ListNode head) {
		ListNode selNode = head;
		ListNode curNode = head.next;
		ListNode smallList = null, biggerList = null, temp = null;

		selNode.next = null;
		if (curNode == null) {
			smallList = head;
		} else {
			while (curNode != null) {
				temp = curNode.next;
				curNode.next = null;
				if (curNode.val < selNode.val) {
					if (null == smallList) {
						smallList = curNode;
					} else {
						smallList = this.append(smallList, curNode);
					}
				} else {
					if (null == biggerList) {
						biggerList = curNode;
					} else {
						biggerList = this.append(biggerList, curNode);
					}
				}

				curNode = temp;
			}

			if (smallList != null) {
				smallList = this.sortList(smallList);
			}

			if (biggerList != null) {
				biggerList = this.sortList(biggerList);
			}
			
			output(smallList);
			output(selNode);
			output(biggerList);

			smallList = this.append(smallList, selNode);
			smallList = this.append(smallList, biggerList);
		}
		
		output(smallList);
		
		return smallList;
	}

	public ListNode append(ListNode head, ListNode nodeList) {
		ListNode lastNode = head;

		if (head != null) {

			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}

			lastNode.next = nodeList;
		} else {
			head = nodeList;
		}
		
		return head;
	}
}
