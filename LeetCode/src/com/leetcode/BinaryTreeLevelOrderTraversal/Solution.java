package com.leetcode.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    
    List<List<Integer>> r = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList al = new ArrayList();
        al.add(3);

        al.add(9);
        al.add(20);

        al.add(null);
        al.add(null);
        al.add(15);
        al.add(7);

        TreeNode tree = creatTree(al);
        
        Solution t = new Solution();
        t.levelOrder(tree);
        
        List<List<Integer>> b = t.r;
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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
           return r; 
        } 
        
        ArrayList<TreeNode> params = new ArrayList<TreeNode>();
        params.add(root);
        help(params);
        
        return r;
    }
    
    public ArrayList<Integer> help(ArrayList<TreeNode> args) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<TreeNode> childrenNode = new ArrayList<TreeNode>();
        
        for(int i = 0; i < args.size(); i ++) {
            TreeNode node = args.get(i);
            if (null != node.left) childrenNode.add(node.left);
            if (null != node.right) childrenNode.add(node.right);
            res.add(node.val);
        }
        
        r.add(res);
        
        if (childrenNode.size() > 0) {
            help(childrenNode);
        }

        return res;
    }
}
