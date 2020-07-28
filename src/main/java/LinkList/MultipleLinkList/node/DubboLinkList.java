package LinkList.MultipleLinkList.node;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import LinkList.MultipleLinkList.node.pojo.Person;

public class DubboLinkList implements LinkList<Person>{

    private Node head;
    private Integer length;

    public DubboLinkList(Person person) {
        this.head.setT(person);
        this.head.setPre(null);
        this.head.setNext(null);
    }

    @Override
    public Integer getLength() {
        return null;
    }

    @Override
    public boolean insert(int index, Node node) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public <T> T select(Object obj) {
        return null;
    }
}
