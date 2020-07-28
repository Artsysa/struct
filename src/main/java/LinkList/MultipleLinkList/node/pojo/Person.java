package LinkList.MultipleLinkList.node.pojo;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.Exchanger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Person {
    private String name;
    private Integer age;
    private String id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}
