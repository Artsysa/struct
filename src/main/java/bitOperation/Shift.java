package bitOperation;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/8/10 20:44
 */
public class Shift {
    public static void main(String[] args) {
        int ctl = 0;
        ctl = Integer.MAX_VALUE << 16;
        System.out.println(Integer.toBinaryString(ctl) + " -> " + ctl);
        ctl = ctl + 2;
        System.out.println(Integer.toBinaryString(ctl) + " -> " + ctl);
        System.out.println(Integer.toBinaryString((1 << 16) - 1 ) + " -> " + ((1 << 16) - 1));
        int sc = ctl & ((1 << 16) - 1);
        System.out.println(Integer.toBinaryString(sc) + " -> " + sc);
        System.out.println(Integer.toBinaryString((1 << 29)));
        System.out.println(Integer.toBinaryString((-1 << 29)));
    }
}
