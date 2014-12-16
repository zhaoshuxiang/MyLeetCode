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
public class ValidateBinarySearchTree {
    public boolean tag = true;
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(10);

        al.add(5);
        al.add(15);
        al.add(null);
        al.add(30);
        al.add(null);
        al.add(20);

        TreeNode tree = Tools.creatTree(al);

        ValidateBinarySearchTree t = new ValidateBinarySearchTree();

        boolean res = t.isValidBST(tree);
    }

    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        
        ArrayList res = inorderTraversal(root);
        
        if(res.size() == 1) return true;
        
        for(int i = 0, j = i + 1; j < res.size(); i++, j++) {
            if ((Integer)res.get(i) >= (Integer)res.get(j)) {
                return false;
            }
        }
        
        return true;
    }
    
    public ArrayList inorderTraversal(TreeNode root) {
        ArrayList res = new ArrayList();
        
        if (null != root) {
            res.addAll(inorderTraversal(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
        }
        
        return res;
    }
}
