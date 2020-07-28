package UnionFind;

/*
 * @breif:并查集
 * @Author: lyq
 * @Date: 2020/5/5 9:51
 * @Month:05
 */
public abstract class UnionFind {

    public int[] collect;
    public UnionFind(int capacity){
        collect=new int[capacity];
        for (int i = 0; i < capacity; i++) {
            collect[i]=i;
        }
    }
    public abstract int find(int v);
    public boolean isSame(int var1,int var2){
        return find(var1)==find(var2);
    }
    public abstract void union(int var1,int var2);
}
