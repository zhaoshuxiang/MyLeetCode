/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.tree;

import com.leetcode.base.Tools;
import com.leetcode.base.TreeNode;
import java.util.ArrayList;

/**
 *
 * @author Shuxiang
 */
public class SameTree {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);

        al.add(null);
        al.add(2);
        al.add(3);
        al.add(4);

        ArrayList bl = new ArrayList();

        bl.add(1);

        bl.add(null);
        bl.add(2);
        bl.add(3);

        TreeNode tree1 = Tools.creatTree(al);
        TreeNode tree2 = Tools.creatTree(bl);

        SameTree t = new SameTree();
        boolean res = t.isSameTree(tree1, tree2);

        System.out.print(res);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = true;

        if (null == p || null == q) {
            if (!(null == p && null == q)) {
                res = false;
            }
        } else {
            if (p.val != q.val) {
                res = false;
            }

            if (!isSameTree(p.left, q.left)) {
                res = false;
            }

            if (!isSameTree(p.right, q.right)) {
                res = false;
            }
        }

        return res;
    }

    public boolean help(TreeNode p, TreeNode q) {
        boolean res = true;

        if (null != p || null != q) {
            if (null != q && null != p) {
                if (p.val != q.val) {
                    res = false;
                }

                if (!help(p.left, q.left)) {
                    res = false;
                }

                if (!help(p.right, q.right)) {
                    res = false;
                }
            } else {
                res = false;
            }
        }

        return res;
    }
}
