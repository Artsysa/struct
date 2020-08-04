package leetcode;

/*
 * @describe:https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @author: lyq
 * @date: 2020/7/28 21:59
 */
public class 平衡二叉树 {
    static boolean isbalance=true;

    public static void main(String[] args) {
        isBalanced(new TreeNode(1));
    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        deepth(root);
        return isbalance;
    }
    public static int deepth(TreeNode root){
        if(root==null)return 0;
        int left=deepth(root.left);
        int right=deepth(root.right);
        if(isbalance)
            isbalance=Math.abs(left-right)<=1;
        return 1+Math.max(left,right);
    }
}
