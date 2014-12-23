/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.tree;

import com.leetcode.base.Tools;
import com.leetcode.base.TreeNode;

/**
 *
 * @author Shuxiang
 */
public class ConvertSortedArrayToBST {

    public static void main(String[] args) {
        int[] a = {1, 3};

        System.out.println((int)Math.nextUp(3 / 1.7) + 1);
        TreeNode res = (new ConvertSortedArrayToBST()).sortedArrayToBST(a);

        Tools.inOrder(res);

    }

    public TreeNode sortedArrayToBST(int[] num) {
        TreeNode root = null;
        TreeNode rLeaf = null;
        for (int i = 0, len = num.length; i < len; i++) {
            TreeNode n = new TreeNode(num[i]);

            if (1 == len) {
                return n;
            }

            if (i <= (int)(len / 2)) {
                n.left = root;
                root = n;
            } else {
                if (null == rLeaf) {
                    root.right = n;
                    rLeaf = n;
                } else {
                    rLeaf.right = n;
                    rLeaf = n;
                }
            }
        }

        return root;
    }
}
