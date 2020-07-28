package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/path-sum/
 * @Author: lyq
 * @Date: 2020/6/7 12:43
 * @Month:06
 */
public class 路径总和 {

    static boolean flag=false;
    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(5);
//        treeNode.left=new TreeNode(4);
//        treeNode.right=new TreeNode(8);
//        treeNode.left.left=new TreeNode(11);
//        treeNode.left.left.left=new TreeNode(7);
//        treeNode.left.left.right=new TreeNode(2);
//        treeNode.right.left=new TreeNode(13);
//        treeNode.right.right=new TreeNode(4);
//        treeNode.right.right.right=new TreeNode(1);
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        System.out.println(hasPathSum(treeNode,1));
    }


    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;

        dfs(root,sum-root.val);
        return flag;
    }

    public static void dfs(TreeNode root,int sum){
        if(root==null||flag)return;
        if(sum==0&&root.left==null&&root.right==null){
            flag=true;
            return;
        }

            int var1=root.left==null?0:root.left.val;
            int var2=root.right==null?0:root.right.val;
            dfs(root.left,sum-var1);
            dfs(root.right,sum-var2);


    }
}
