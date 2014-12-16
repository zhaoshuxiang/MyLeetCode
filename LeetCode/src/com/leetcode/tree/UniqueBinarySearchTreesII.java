/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.tree;

import com.leetcode.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shuxiang
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        UniqueBinarySearchTreesII t = new UniqueBinarySearchTreesII();
        t.generateTrees(5);
    }

    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> root = new ArrayList<TreeNode>();
        
        if (0 == n) {
          root.add(null);
          return root;
        }
        
        for (int i = 1; i <= n; i++) {
            if (1 == i) {
                root.add(new TreeNode(i));
            } else {
                root = b(root, i);
            }
        }

//        for(int j= 0; j < root.size(); j++) {
//            Tools.inOrder(root.get(j));
//            System.out.print("\n");
//        }
        System.out.print(root.size());
        return root;
    }

    public ArrayList<TreeNode> b(ArrayList<TreeNode> t, int n) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();

        for (int i = 0; i < t.size(); i++) {
            TreeNode root = t.get(i);

            TreeNode node = new TreeNode(n);
            // 原有树作为当前节点的左子树
            node.left = root;
            res.add(node);

            // 将当前节点插入原有树中
            res.addAll(t(root, root, new TreeNode(n)));

        }

        return res;
    }

    public ArrayList<TreeNode> t(TreeNode R, TreeNode r, TreeNode n) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();

        if (null != r) {
            TreeNode w = i(R, r, n);
            res.add(w);
            res.addAll(t(R, r.right, n));
        }

        return res;
    }

    // 遍历、克隆R树，找到R的p节点，插入n节点
    public TreeNode i(TreeNode R, TreeNode p, TreeNode n) {
        if (null == R) {
            return R;
        }
        TreeNode c = new TreeNode(R.val);

        if (R == p) {
            c.left = i(R.left, p, n);

            TreeNode tmp = i(R.right, p, n);
            TreeNode x = new TreeNode(n.val);
            x.left = tmp;

            c.right = x;
        } else {
            c.left = i(R.left, p, n);
            c.right = i(R.right, p, n);
        }

        return c;
    }
}
