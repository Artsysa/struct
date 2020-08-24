package finall;

import java.lang.reflect.Field;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/8/17 9:36
 */
public class AtlerFinal {
    final String b = "aaa";

    public static void main(String[] args) throws IllegalAccessException {
        AtlerFinal atler = new AtlerFinal();
        System.out.println(atler.b);
        Field[] fileds = AtlerFinal.class.getDeclaredFields();
        for (Field field : fileds) {
            if (field.getName().equals("b")) {
                field.setAccessible(false);
                field.set(field.getName(), "cccc");
            }
        }
        System.out.println(atler.b);
    }
}
