package com.leetcode.linklist;

import com.leetcode.base.ListNode;
import com.leetcode.base.TreeNode;
import java.util.ArrayList;

public class ConvertSortedListToBinarySearchTree {

    int curNodeLevel = 0;
    int maxLevel = -1;

    public static void main(String[] args) {

        ArrayList al = new ArrayList();
        al.add(1);

        al.add(2);
        al.add(2);

        al.add(null);
        al.add(5);
        al.add(5);
        al.add(5);

        al.add(8);
        al.add(8);
        al.add(8);
        al.add(8);
        al.add(8);
        al.add(8);
        al.add(8);
        al.add(8);

        TreeNode tree = creatTree(al);
        outputTree(tree);
    }

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

    public int maxDepth(TreeNode root) {

        if (null != root) {
            if (this.curNodeLevel == 0) {
                this.curNodeLevel = 1;
            }

            // 左边叶子节点
            if (null != root.left) {
                this.curNodeLevel = this.curNodeLevel + 1;
                this.maxDepth(root.left);
                this.curNodeLevel = this.curNodeLevel - 1;
            }

            // 右边叶子节点
            if (null != root.right) {
                this.curNodeLevel = this.curNodeLevel + 1;
                this.maxDepth(root.right);
                this.curNodeLevel = this.curNodeLevel - 1;
            }

            // 是叶子节点
            if (null == root.left && null == root.right) {
                if (-1 == this.maxLevel || this.curNodeLevel > this.maxLevel) {
                    this.maxLevel = this.curNodeLevel;
                }
            }
        } else {
            this.maxLevel = 0;
        }

        return this.maxLevel;
    }

    public static ArrayList traverse(TreeNode root) {
        int i = 0;
        ArrayList res = new ArrayList();
        res.add(root);

        while (res.size() >= i + 1) {
            TreeNode node = (TreeNode) res.get(i);

            if (null != node) {
                if (null != node.left || null != node.right) {
                    res.add(node.left);
                    res.add(node.right);
                }
            }

            i = i + 1;
        }

//        for (int j = 0; j < res.size(); j++) {
//            if (null == res.get(j)) {
//                System.out.print("null ");
//            } else {
//                System.out.print(((TreeNode) res.get(j)).val + " ");
//            }
//            
//        }
        return res;
    }

    public static void outputTree(TreeNode tree) {
        // 树的深度
        int level = (new ConvertSortedListToBinarySearchTree()).maxDepth(tree);
        int maxLeafNum = (int) Math.pow(2.0, level - 1);
        maxLeafNum = 2 * maxLeafNum - 1;

        // 横向遍历树
        ArrayList t = traverse(tree);

        // 输出数组
        String[][] sss = new String[level][maxLeafNum];

        for (int j = 1; j <= level; j++) {
            // 前置空格
            int blankNum = 5 * (int) Math.pow(2, (level - j)) - 2;
            if (level != j) {
                System.out.print(blankStr((int)(blankNum * 0.25)));
            }

            // 内容，穿插空格
            int begin = (((int) Math.pow(2, j - 1) - 1) + 1) - 1;
            int end = ((int) Math.pow(2, j) - 1) - 1;
            for (int i = begin, num = 1; i <= end; i++, num++) {
                if (t.size() > i) {
                    if (null == t.get(i)) {
                        // 如果节点为空，补齐子节点
                        System.out.print("*");
                        int leftChildIndex = end + 2 * (num - 1) + 1;
                        if (t.size() >= leftChildIndex) {
                            t.add(leftChildIndex, null);
                            t.add(leftChildIndex + 1, null);
                        }

                    } else {
                        System.out.print(((TreeNode) t.get(i)).val);
                    }
                } else {
                    System.out.print("*");
                }

//                int a = (int) Math.pow(2, level - j + 1) - 1;
                if (j == level) {
                    if (0 != i % 2) {
                        System.out.print(blankStr(blankNum));
                    }
                } else {
                    System.out.print(blankStr((int)(blankNum * 0.5)));
                }
            }

            System.out.print("\n");
        }
    }

    public static String blankStr(int n) {
        String s = "";

        for (int i = 0; i < n; i++) {
            s = s + " ";
        }

        return s;
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

    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }
}
