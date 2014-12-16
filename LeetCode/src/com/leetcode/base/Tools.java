/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.base;

import java.util.ArrayList;

/**
 *
 * @author Shuxiang
 */
public class Tools {

    // 根据ArrayList生成树
    public static TreeNode creatTree(ArrayList al) {
        int len = al.size();
        int tag = 2;
        TreeNode root = null, node = null, parentNode = null;
        // 队列
        ArrayList cache = new ArrayList();

        for (int i = 0; i < len; i++) {

            if (0 == i) {
                node = new TreeNode((Integer) al.get(i));
                root = node;
                cache.add(root);
            } else {
                if (null != al.get(i)) {
                    node = new TreeNode((Integer) al.get(i));
                } else {
                    node = null;
                }

                if (2 == tag) {
                    parentNode = (TreeNode) cache.get(0);
                    cache.remove(0);
                    tag = 1;
                    parentNode.left = node;
                } else {
                    parentNode.right = node;
                    tag = tag + 1;
                }

                if (null != node) {
                    cache.add(node);
                }
            }

        }

        return root;
    }
    
    // 中序遍历一颗树
    public static void inOrder(TreeNode root) {
        if (null != root) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // 数组转换成链表
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

//        endNode.next = beginNode;

        return beginNode;
    }

    // 向控制台输出链表
    public static void outputLinkList(ListNode root) {
        if (root != null) {
            System.out.print(Integer.toString(root.val) + " ");

            if (null != root.next) {
                Tools.outputLinkList(root.next);
            } else {
                System.out.println("");
            }
        } else {
            System.out.println("null");
        }
    }
}
