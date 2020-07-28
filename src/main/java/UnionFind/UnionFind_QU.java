package UnionFind;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/5/5 10:51
 * @Month:05
 */
public class UnionFind_QU extends UnionFind {

    public UnionFind_QU(int capacity){
        super(capacity);
    }

    @Override
    public int find(int v) {
        while(v!=collect[v]){
            v=collect[v];
        }
        return v;
    }

    @Override
    public void union(int var1, int var2) {
         if(isSame(var1,var2)) return;
        collect[find(var1)]=find(var2);
    }
}
