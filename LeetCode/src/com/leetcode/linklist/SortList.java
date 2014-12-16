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
        int[] a = {4, 1, 3, 2, 8, 9, 12, 10};

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
        ListNode s = null;
        ListNode sE = null;
        
        while(c.next != null) {
            if (c.next.val < t.val) {
                sE = c.next;
                c.next = sE.next;
                
                if (null == s) {
                    sE.next = null;
                    s = sE;
                } else {
                    s.next = sE;
                }
            } else {
               c = c.next; 
            }
        }

        ListNode lN = sortList(s);
        ListNode rN = sortList(t.next);



        return join(lN, t, rN);
    }

    public ListNode join(ListNode a, ListNode b, ListNode c) {
        ListNode l = a;

        if (null != a) {
            while (null != l.next) {
                l = l.next;
            }
            
            l.next = b;
        }

        b.next = c;

        return null == a ? b : a;
    }
}
