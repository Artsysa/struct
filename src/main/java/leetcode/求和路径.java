package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/paths-with-sum-lcci/
 * @Author: lyq
 * @Date: 2020/6/8 22:50
 * @Month:06
 */
public class 求和路径 {
    Integer count=0;


    public static void main(String[] args) {
                TreeNode treeNode = new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(8);
        treeNode.left.left=new TreeNode(11);
        treeNode.left.left.left=new TreeNode(7);
        treeNode.left.left.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(13);
        treeNode.right.right=new TreeNode(4);
        treeNode.right.right.left=new TreeNode(5);
        treeNode.right.right.right=new TreeNode(1);
        求和路径 a = new 求和路径();
        System.out.println(a.pathSum(treeNode,22));
    }

    public int pathSum(TreeNode root, int sum) {

        dfs(root,sum-root.val);
        return count;
    }
    public void dfs(TreeNode root, int sum){
        if(sum<0||root==null)return;
        if(sum==0&&root.left==null&&root.right==null)
        {
            count++;
            return;
        }
        int var1=root.left==null?0:root.left.val;
        int var2=root.right==null?0:root.right.val;
        dfs(root.left,sum-var1);
        dfs(root.right,sum-var2);
    }

}
