package jvm.init;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/7/29 13:31
 */
public class StaticInitTest {
    static{
        System.out.println("father");
    }
    public static int value=1;
    public final static int value1=2;
}

class SubClass extends StaticInitTest{
    static{
        System.out.println("subclass");
    }
}

class test{
    public static void main(String[] args) {
        System.out.println(SubClass.value1);
       // System.out.println(SubClass.value);
    }
}
