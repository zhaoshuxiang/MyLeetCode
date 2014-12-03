/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.tree;

import com.leetcode.base.Tools;
import com.leetcode.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shuxiang
 */
public class SymmetricTree {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);

        al.add(2);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(4);
        al.add(3);

        TreeNode tree = Tools.creatTree(al);

        SymmetricTree t = new SymmetricTree();

        boolean res = t.isSymmetric(tree);

        System.out.print(res);
    }

    public boolean isSymmetric(TreeNode root) {
        if(null == root) return true;
        return isMatch(root.left, root.right);
    }
    
    public boolean isMatch(TreeNode left, TreeNode right) {
        if (null == left && null == right) return true;
        if (null != left && null ==right || null == left && null !=right || left.val != right.val) return false; 
        return isMatch(left.left, right.right) && isMatch(left.right, right.left);
    }
}
