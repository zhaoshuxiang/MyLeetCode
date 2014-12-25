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
    private ArrayList<Integer> l = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        
        al.add(4);

        al.add(9);
        al.add(0);
        al.add(null);
        al.add(1);
        
        TreeNode tree = Tools.creatTree(al);
        int res = (new SumRootToLeafNumbers()).sumNumbers(tree);

        System.out.print(res);
    }
    
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        
        if( null != root) {
            this.l.add(root.val);
            
            if (null == root.left && null == root.right) {
                sum = sum + s();
                System.out.print(sum + " ");
            } else {
                sum = sum + sumNumbers(root.left);
                sum = sum + sumNumbers(root.right);
            }
            
            this.l.remove(this.l.size() - 1);
        }
        
        return sum;
    }
    
    public int s() {
        ArrayList<Integer> a = this.l;
        int len = a.size();
        int sum = 0;
        
        for(int i = 0; i < len;i ++)  {
            sum = sum + a.get(i) * (int)Math.pow(10, len - i - 1);
        }
        
        
        
        return sum;
    }
}
