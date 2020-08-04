package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * @describe:https://leetcode-cn.com/problems/palindrome-partitioning/
 * @author: lyq
 * @date: 2020/7/30 13:04
 */
public class 分割回文串 {

    public static void main(String[] args) {
        partition("aab");
    }


    public static List<List<String>> partition(String s) {
        int length = s.length();
        char[] str = s.toCharArray();
        boolean[][] isString = new boolean[length][length];
        //初始化
        for (int i = 0; i < length; i++) {
            isString[i][i]=true;
        }
        for (int i = length - 2; i >= 0 ; i--) {
            for (int j = i + 1; j < length; j++){
                if(j-i == 1) {
                    isString[i][j] = str[i] == str[j];
                }
                else if(str[i] == str[j]){
                    isString[i][j] = isString[i + 1][j - 1];
                }else{
                    isString[i][j] = false;
                }
            }
        }
        List<List<String>> list = new ArrayList<>();
       // dfs(list,0,isString,str,new ArrayList<>());
        dfs2(s,0,new ArrayList<>(),isString,list);
        list.forEach(System.out::println);
        return null;
    }


    public static void dfs(List<List<String>> list, int index, boolean[][] aim, char[] source, List<String> temp){
        if(index == source.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < aim.length ; i++) {
           if(aim[index][i]){
               temp.add(new String(source,index,i-index+1));
               dfs(list,index+1,aim,source,temp);
               temp.remove(temp.size()-1);
           }
        }
    }

    private static void dfs2(String str, int start, List<String> item, boolean[][] dp, List<List<String>> ans) {
        if (start == str.length()) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = start + 1; i <= str.length(); i++) {
            if (dp[start][i - 1]) {
                item.add(str.substring(start, i));
                dfs2(str, i, item, dp, ans);
                item.remove(item.size() - 1);
            }
        }
    }
}

/**
 *
 */