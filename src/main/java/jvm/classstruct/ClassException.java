package jvm.classstruct;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/7/28 10:56
 */
public class ClassException {
    private static int b=1;
    private  int c=1;
    public static void main(String[] args) {

    }

    public int testerror(){
        int i;
        try {
           i=1;
           return i;
        } catch (Exception e) {
           i=1;
        }finally {
            i=3;
            return i;
        }
    }
}
