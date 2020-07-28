package map;







import java.util.ArrayList;
import java.util.Iterator;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/6/19 19:08
 * @Month:06
 */
public class ListItTest
{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
