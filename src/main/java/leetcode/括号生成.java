package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @breif:https://leetcode-cn.com/problems/generate-parentheses/
 * @Author: lyq
 * @Date: 2020/6/5 13:00
 * @Month:06
 */
public class 括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        dfs(0,list,new char[n<<1],n,n);
        return list;
    }

    public static void dfs(int level, List<String> list, @org.jetbrains.annotations.NotNull char[] cha, int left, int right){
        if(level==cha.length){
            list.add(new String(cha));
            return ;
        }
        if(left>0){
            cha[level]='(';
            dfs(level+1,list,cha,left-1,right);
        }if(right>0&&right!=left){
            cha[level]=')';
            dfs(level+1,list,cha,left,right-1);
        }
    }
}
