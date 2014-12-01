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
public class SumRootToLeafNumbers {
    
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        
        al.add(1);

        al.add(null);
        al.add(2);
        al.add(3);
        al.add(4);
        
        TreeNode tree = Tools.creatTree(al);

        SumRootToLeafNumbers t = new SumRootToLeafNumbers();
        int res = t.sumNumbers(tree);

        System.out.print(res);
    }
    
    
    public int sumNumbers(TreeNode root) {
        int res = 0;
        
        if (null != root) {
            
            
            
            sumNumbers(root.left);
            sumNumbers(root.right);
        }
        
        return res;
    }
}
