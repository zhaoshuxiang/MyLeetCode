/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.tree;

import com.leetcode.base.TreeNode;
import java.util.ArrayList;

/**
 *
 * @author Shuxiang
 */
public class MinimumDepthOfBinaryTree {

    int curNodeLevel = 0;
    int minLevel = -1;

    public static void main(String[] args) {

        ArrayList al = new ArrayList();
        al.add(1);
        al.add(8);
        al.add(7);
        al.add(null);
        al.add(null);
        al.add(3);
        al.add(5);
        al.add(null);
        al.add(null);
        al.add(4);
        al.add(null);
        al.add(9);
        al.add(null);
        al.add(10);

        TreeNode tree = creatTree(al);

        int res = (new MinimumDepthOfBinaryTree()).minDepth(tree);
        System.out.print(res);
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

    public int minDepth(TreeNode root) {

        if (null != root) {
            if (this.curNodeLevel == 0) {
                this.curNodeLevel = 1;
            }

            // 左边叶子节点
            if (null != root.left) {
                this.curNodeLevel = this.curNodeLevel + 1;

                this.minDepth(root.left);

                this.curNodeLevel = this.curNodeLevel - 1;

            }

            // 右边叶子节点
            if (null != root.right) {
                this.curNodeLevel = this.curNodeLevel + 1;

                this.minDepth(root.right);

                this.curNodeLevel = this.curNodeLevel - 1;
            }

            // 是叶子节点
            if (null == root.left && null == root.right) {
//                System.out.print(this.curNodeLevel + " ");

                if (-1 == this.minLevel || this.curNodeLevel < this.minLevel) {
                    this.minLevel = this.curNodeLevel;
                }

//                System.out.print(this.minLevel + " ");
//                System.out.print("\n");
            }
        } else {
            this.minLevel = 0;
        }

        return this.minLevel;
    }

    // 前序遍历
    public void traverse(TreeNode root) {
        if (null != root) {
            // 左边叶子节点
            if (null != root.left) {
                if (null != root.left.left || null != root.left.right) {
                    this.traverse(root.left);
                } else {
                    System.out.print(root.left.val + " ");
                }
            }
            
            System.out.print(root.val + " ");
            
            // 右边叶子节点
            if (null != root.right) {
                if (null != root.right.left || null != root.right.right) {
                    this.traverse(root.right);
                } else {
                    System.out.print(root.right.val + " ");
                }
            }
        }
    }
}
