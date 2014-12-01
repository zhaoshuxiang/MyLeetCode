package com.leetcode.tree;

import com.leetcode.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    // 遍历的路径
    ArrayList<Integer> curPath = new ArrayList<Integer>();

    public static void main(String[] args) {

        ArrayList al = new ArrayList();
        al.add(1);

        al.add(null);
        al.add(2);
        al.add(3);

        TreeNode tree = creatTree(al);
        
//        TreeNode tree = new TreeNode(1);
        
        List<Integer> res = (new BinaryTreePreorderTraversal()).preorderTraversal(tree);
        
        for(int i = 0; i < res.size(); i ++) {
            System.out.print(res.get(i) + " ");
        }
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

    public List<Integer> preorderTraversal(TreeNode root) {
        
        if (null != root) {
            this.curPath.add(root.val);
            this.preorderTraversal(root.left);
            this.preorderTraversal(root.right);  
        }
        
        return this.curPath;
    }
}
