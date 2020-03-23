package pers.pgb.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树
 */
public class BinaryTree {
    /**
     * 返回所有的路径
     * @param node 根节点
     */
    public static List<List<Integer>> foreachAllPath(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(node);
        backTracking(result, linkedList);
        return result;
    }

    private static void backTracking(List<List<Integer>> result, LinkedList<TreeNode> linkedList) {
        TreeNode node = linkedList.getLast();
        // node 为叶子节点
        if (node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            for (TreeNode treeNode : linkedList) {
                if (treeNode != null) {
                    list.add(treeNode.val);
                }
            }
            result.add(list);
            return;
        }

        if (node.left != null) {
            TreeNode left = node.left;
            linkedList.addLast(left);
            backTracking(result, linkedList);
            linkedList.pollLast();
        }


        if (node.right != null) {
            TreeNode right = node.right;
            linkedList.addLast(right);
            backTracking(result, linkedList);
            linkedList.pollLast();
        }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n2.left = n4;
        n2.right = n5;
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n3.left = n6;
        n3.right = n7;

        List<List<Integer>> result = foreachAllPath(n1);

        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }


}
