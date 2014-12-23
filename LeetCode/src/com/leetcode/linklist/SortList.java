package com.leetcode.linklist;

//import java.io.BufferedReader;
import com.leetcode.base.ListNode;
import com.leetcode.base.Tools;

//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
public class SortList {

    public static void main(String[] args) {
//        int[] a = {4, 1, 3, 2, 8, 9, 12, 10};
//        int[] a = {4, 3, 2, 1, 0};
        int[] a = {0, 1, 2, 3, 4};

        ListNode b = Tools.coverArrayToList(a);
        ListNode s = (new SortList()).sortList(b);

        Tools.outputLinkList(s);
    }

    public ListNode sortList(ListNode head) {
        if (null == head) {
            return head;
        }

        // 标准节点
        ListNode t = head;
        
        // 当前的节点
        ListNode c = head;

        // 小于标准节点的
        ListNode sE = null;
        
        while(c.next != null) {
            if (c.next.val < t.val) {
                ListNode tmp = c.next;
                c.next = tmp.next;
                                
                if (t == head) {
                    head = tmp;
                    sE = tmp;
                    head.next = t;
                } else {
                    tmp.next = head;
                    head = tmp;
                }
            } else {
               c = c.next; 
            }
        }

        ListNode res = head;
        if (head != t) {
            res = test(head, sE);
        }
        if (null != t.next) {
            t.next = test(t.next, c);
        }
        

        return res;
    }
    
    public ListNode test(ListNode head, ListNode end) {
        if (head == end) {
            return head;
        }

        // 标准节点
        ListNode t = head;
        
        // 当前的节点
        ListNode c = head;

        // 小于标准节点的
        ListNode sE = null;
        
        boolean a = true;
        while(null != c.next && a) {
            if (c.next == end) a = false;
            if (c.next.val < t.val) {
                ListNode tmp = c.next;
                c.next = tmp.next;
                                
                if (t == head) {
                    head = tmp;
                    sE = tmp;
                    head.next = t;
                } else {
                    tmp.next = head;
                    head = tmp;
                }
            } else {
               c = c.next; 
            }
        }

        if (head != t) {
            head = test(head, sE);
        }
        
        
        if (null != t.next) {
            t.next = test(t.next, c);
        }
        
        return head;
    }
}
