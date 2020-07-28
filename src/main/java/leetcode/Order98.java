package leetcode;

import tree.BinarySearchTree;

import javax.swing.tree.TreeNode;

/*
 * @breif:https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @Author: lyq
 * @Date: 2020/5/5 12:15
 * @Month:05
 */
public class Order98 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);

    }
}


//  Definition for a binary tree node.

//
//class Solution {
//    public static boolean isValidBST(Node root) {
//        return search(root);
//    }
//    public static boolean search(Node root){
//        search(root.left);
//
//        if(root.val>root.left.val&&root.val<root.right.val) return true;
//        else return false;
//    }
//}