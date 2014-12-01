package com.leetcode.tree;

import com.leetcode.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {

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
        
        BinaryTreeMaximumPathSum t = new BinaryTreeMaximumPathSum();
        t.maxPathSum(tree);
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
    
    public int maxPathSum(TreeNode root) {
        
        return 0;
    }
}
