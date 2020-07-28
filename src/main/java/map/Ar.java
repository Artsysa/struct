package map;

/*
 * @breif:map接口
 * @Author: lyq
 * @Date: 2020/4/28 11:30
 * @Month:04
 */
public interface Ar<K,V> {

    int size();

    void clean();

    V get(K k);

    V remove(K k);

    V put(K K,V v);
}
