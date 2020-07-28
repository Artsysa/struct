package leetcode;

import lombok.Data;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/6/7 12:43
 * @Month:06
 */
@Data
public class TreeNode {
    int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
}
