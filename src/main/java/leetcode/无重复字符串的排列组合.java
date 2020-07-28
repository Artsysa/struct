package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @breif:https://leetcode-cn.com/problems/permutation-i-lcci/
 * @Author: lyq
 * @Date: 2020/6/9 22:59
 * @Month:06
 */
public class 无重复字符串的排列组合 {
    public static void main(String[] args) {
        无重复字符串的排列组合 s = new 无重复字符串的排列组合();
        System.out.println(s.permutation("qwe"));
    }

    public String[] permutation(String S) {
        List<String> list=new ArrayList<>();
        char[] chars = S.toCharArray();
        dfs(0,chars,list,new char[S.length()],new boolean[S.length()]);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(int index,char[] s,List<String> list,char[] tmp,boolean[] use){
        if(index==s.length){
            list.add(String.valueOf(tmp));
            return ;
        }
        for(int i=0;i<s.length;i++){
            if(use[i])continue;;
            tmp[index]=s[i];
            use[i]=true;
            dfs(index+1,s,list,tmp,use);
            use[i]=false;
        }
    }
}
