/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.base;

import java.util.ArrayList;

/**
 *
 * @author Shuxiang
 */
public class Tools {
    
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
    
    
    
}
