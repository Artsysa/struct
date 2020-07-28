package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/valid-anagram/
 * @Author: lyq
 * @Date: 2020/6/3 15:39
 * @Month:06
 */
public class 有效的字母异位词 {
    public static void main(String[] args) {
        System.out.println(isAnagram("a","b"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] ch1=s.toCharArray();
        char[] ch2=t.toCharArray();
        int[] count=new int[26];
        int len=s.length();
        for(int i=0;i<len;i++){
            count[ch1[i]-'a']++;
        }
        for(int i=0;i<len;i++)
        {
            if(--count[ch2[i]-'a']<0)
                return false;
        }
        return true;
    }
}
