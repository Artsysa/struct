package jvm.various;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/8/3 14:58
 */
public class MethodVarious {
    static abstract class Human{

    }
    static class Man extends Human{

    }
    static class Women extends Human{

    }
    public void say(Human human){
        System.out.println("human");
    }
    public void say(Man man){
        System.out.println("Man");
    }
    public void say(Women women){
        System.out.println("Women");
    }

    public static void main(String[] args) {
        MethodVarious methodVarious = new MethodVarious();
        Man man = new Man();
        Women women = new Women();
        methodVarious.say(man);
        methodVarious.say(women);
    }
}
