package test;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/7 22:04
 * @Month:07
 */
public abstract class TestAbstract {
    TestAbstract(){
        System.out.println("gggggggg");
    }
    private String a;
     class hh{
        public void tt(){
            a="dd";
        }
     }
    public void t(){}
}

class Sub extends  TestAbstract{
    Sub(){
        System.out.println("cccc");
    }


    @Override
    public void t() {
        super.t();
    }

    public static void main(String[] args) {
        Sub sub = new Sub();

    }
}

 abstract class aaa{
    public  abstract void a();
    public static void b(){

    }
        }

