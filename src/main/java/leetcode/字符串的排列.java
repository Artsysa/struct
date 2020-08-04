package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @describe:https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @author: lyq
 * @date: 2020/7/28 17:14
 */
public class 字符串的排列 {
    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Set<String> list = new HashSet<>();
        dfs(list,0,new char[chars.length],chars,new boolean[chars.length]);
        String[] resultVal = new String[list.size()];
        list.toArray(resultVal);
        System.out.println(list);
        return resultVal;
    }

    public static void dfs(Set<String> list, int index, char[] used, char[] str, boolean[] isused){
        if(index == str.length){
            String strs = "";
            for (int i = 0; i < used.length; i++) {
                strs+=used[i];
            }
            list.add(strs);
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if(isused[i])
                continue;
            used[index]=str[i];
            isused[i]=true;
            dfs(list,index+1,used,str,isused);
            isused[i]=false;
        }
    }

    public static void main(String[] args) {
        String[] ret = permutation("abc");
        for (String i:ret){
           // System.out.println(ret);
        }
        System.out.println(ret.length);
    }
}
