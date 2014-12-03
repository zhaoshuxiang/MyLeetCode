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
public class BalancedBinaryTree {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);

        al.add(2);
        al.add(5);
        al.add(3);
        al.add(null);
        al.add(null);
        al.add(null);
        al.add(4);

        TreeNode tree = Tools.creatTree(al);

        BalancedBinaryTree t = new BalancedBinaryTree();

        boolean res = t.isBalanced(tree);
        System.out.print(res);
    }

    public boolean isBalanced(TreeNode root) {
        return depthDif(root) >= 0;
    }
    
    public int depthDif(TreeNode root) {

        if (null == root) {
            return 0;
        }

        int leftDepth = depthDif(root.left);
        int rightDepth = depthDif(root.right);

        if (leftDepth >= 0 && rightDepth >= 0 && Math.abs(leftDepth - rightDepth) <= 1) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            // 代表不是平衡二叉树
            return -1;
        }
    }
}
