package LinkList.MultipleLinkList.node;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

public interface LinkList<T> {

    public Integer getLength();
    public boolean insert(int index,Node node);
    public boolean delete(int index);
    public  <T> T select(Object obj);
}
