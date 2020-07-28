package UnionFind;

/*
 * @breif:查找快 O（1）级别，树的高度均为2，但联合慢，o（n）
 * @Author: lyq
 * @Date: 2020/5/5 10:16
 * @Month:05
 */
public class UnionFind_QF extends UnionFind {

    public UnionFind_QF(int capacity){
        super(capacity);
    }

    @Override
    public int find(int v) {
        return collect[v];
    }

    @Override
    public void union(int var1, int var2) {
       if(isSame(var1,var2))return;
        for (int i = 0; i < collect.length; i++) {
            if(collect[i]==find(var1)){
                collect[i]=find(var2);
            }
        }
    }
}
