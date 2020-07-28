package LinkList.MultipleLinkList.node;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Node<T> {
    private Node pre;
    private Node next;
    private T t;

    @Override
    public String toString() {
        return "Node{" +
                "pre=" + pre +
                ", next=" + next +
                ", t=" + t +
                '}';
    }
}
