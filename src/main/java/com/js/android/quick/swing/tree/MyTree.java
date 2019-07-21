package com.js.android.quick.swing.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 作者:Audragon
 * @version 创建时间：2013-10-11
 * @todo 功能：刷新树，保存树的刷新前的展开状态
 */
public class MyTree extends JFrame {
    JTree tree;
    DefaultTreeModel defaultTreeModel;
    DefaultMutableTreeNode root;

    JPanel btnPanel;

    public MyTree() {
        root = new DefaultMutableTreeNode("树");
        defaultTreeModel = new DefaultTreeModel(root);
        tree = new JTree(defaultTreeModel);
        addNode(root, 4);

        btnPanel = new JPanel();
        JButton refresh = new JButton("刷新");
        refresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateTree();
            }
        });
        btnPanel.add(refresh);
        this.add(tree);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addNode(DefaultMutableTreeNode node, int n) {
        for (int i = 1; i <= n; i++) {
            DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(i);
            for (int m = 1; m <= n; m++) {
                DefaultMutableTreeNode newChild2 = new DefaultMutableTreeNode(m);
                for (int j = 1; j <= n; j++) {
                    DefaultMutableTreeNode newChild3 = new DefaultMutableTreeNode(m);
                    newChild2.add(newChild3);
                }
                newChild.add(newChild2);
            }
            node.add(newChild);
        }
    }

    /***
     * 刷新树，不更改树原来的展开状态
     */
    public void updateTree() {
        Vector<TreePath> v = new Vector<TreePath>();
        getExpandNode(root, v);
        root.removeAllChildren();
        addNode(root, 3);
        defaultTreeModel.reload();

        int n = v.size();
        for (int i = 0; i < n; i++) {
            Object[] objArr = v.get(i).getPath();
            Vector<Object> vec = new Vector<Object>();
            int len = objArr.length;
            for (int j = 0; j < len; j++) {
                vec.add(objArr[j]);
            }
            expandNode(tree, root, vec);
        }
    }

    public Vector<TreePath> getExpandNode(TreeNode node, Vector<TreePath> v) {
        if (node.getChildCount() > 0) {
            TreePath treePath = new TreePath(defaultTreeModel.getPathToRoot(node));
            if (tree.isExpanded(treePath)) v.add(treePath);
            for (Enumeration e = node.children(); e.hasMoreElements(); ) {
                TreeNode n = (TreeNode) e.nextElement();
                getExpandNode(n, v);
            }
        }
        return v;
    }

    /**
     * @param myTree   树
     * @param currNode 展开节点的父节点
     * @param vNode    展开节点，路径字符串|路径Node组成的Vector，按从根节点开始，依次添加到Vector
     */
    void expandNode(JTree myTree, DefaultMutableTreeNode currNode, Vector<Object> vNode) {
        if (currNode.getParent() == null) {
            vNode.removeElementAt(0);
        }
        if (vNode.size() <= 0) return;

        int childCount = currNode.getChildCount();
        String strNode = vNode.elementAt(0).toString();
        DefaultMutableTreeNode child = null;
        boolean flag = false;
        for (int i = 0; i < childCount; i++) {
            child = (DefaultMutableTreeNode) currNode.getChildAt(i);
            if (strNode.equals(child.toString())) {
                flag = true;
                break;
            }
        }
        if (child != null && flag) {
            vNode.removeElementAt(0);
            if (vNode.size() > 0) {
                expandNode(myTree, child, vNode);
            } else {
                myTree.expandPath(new TreePath(child.getPath()));
            }
        }
    }

    public static void main(String args[]) {
        new MyTree();
    }
}