package com.leetcode.SortList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static String testData[] = {};

	public static void main(String[] args) {
		ListNode beginNode = null, endNode = null;

		// 读取文件里的测试数据
		try {
			String dataStr = "";
			String filePath = "C:\\Users\\Shuxiang\\Desktop\\a.txt";
			File fileName = new File(filePath);
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(fileName));

			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

			dataStr = br.readLine();
			
			
			testData = dataStr.split(",");
			
//			while (dataStr != null) {
//				dataStr = br.readLine(); // 一次读入一行数据
//				System.out.println(dataStr);
//			}
			
			
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0, len = testData.length; i < len; i++) {
			if (0 == i) {
				beginNode = new ListNode( Integer.parseInt(testData[i]));
				endNode = beginNode;
			} else {
				endNode.next = new ListNode(Integer.parseInt(testData[i]));
				endNode = endNode.next;
			}
		}

//		output(beginNode)
		long a = System.currentTimeMillis();
		Solution s = new Solution();
		ListNode res = s.sortList(beginNode);
		long b = System.currentTimeMillis();
		
		System.out.println(Long.toString(b - a));
//		output(res);
		
		// 将排序结果写到文件里
		try {
			String filePath = "C:\\Users\\Shuxiang\\Desktop\\a_f.txt";
			File fileName = new File(filePath);
			OutputStreamWriter reader = new OutputStreamWriter(
					new FileOutputStream(fileName));
			
			BufferedWriter out = new BufferedWriter(reader); 
			
			while(null != res.next) {
				out.write(Integer.toString(res.next.val));
				res = res.next;
			}
			
            out.flush(); // 把缓存区内容压入文件  
            out.close(); // 最后记得关闭文件  
			
		} catch( Exception e) {
			e.printStackTrace();
		}
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
		if (null == head) {
			return head;
		}

		ListNode selNode = head, curNode = null;
		ListNode smallList = null, smallListEnd = null;
		ListNode biggerList = null, biggerListEnd = null;
		ListNode temp = null;

		curNode = head.next;
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
						smallListEnd = curNode;
					} else {
						smallListEnd.next = curNode;
						smallListEnd = curNode;
					}
				} else {
					if (null == biggerList) {
						biggerList = curNode;
						biggerListEnd = curNode;
					} else {
						biggerListEnd.next = curNode;
						biggerListEnd = curNode;
					}
				}

				curNode = temp;
			}

			// 递归分治
			if (null != smallList && null != smallList.next) {
				smallList = this.sortList(smallList);
			}

			if (null != biggerList && null != biggerList.next) {
				biggerList = this.sortList(biggerList);
			}

			// 连接
			if (smallList == null) {
				selNode.next = biggerList;
				smallList = selNode;
			} else {
				smallListEnd = smallList;
				while (null != smallListEnd.next) {
					smallListEnd = smallListEnd.next;
				}

				smallListEnd.next = selNode;
				selNode.next = biggerList;
			}
		}

		return smallList;
	}
}
