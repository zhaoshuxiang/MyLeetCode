package com.leetcode.SortList;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

public class Solution {
    
    public static void main(String[] args) {
        int [] a = {4, 1, 3, 2, 8 , 9, 12, 10};
        ListNode b = coverArrayToList(a);
        
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
        
        endNode.next = beginNode;

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

            if (null != smallList && null != smallList.next) {
                smallList = this.sortList(smallList);
            }

            if (null != biggerList && null != biggerList.next) {
                biggerList = this.sortList(biggerList);
            }

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
