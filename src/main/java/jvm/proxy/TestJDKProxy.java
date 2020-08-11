package jvm.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/8/7 8:46
 */
public class TestJDKProxy {
    static interface Ant{
        public void say();
    }
    static class AntProxy implements InvocationHandler{
        Object orgin;
        Object getProxy(Object orgin){
            this.orgin = orgin;
            return Proxy.newProxyInstance(orgin.getClass().getClassLoader(),
                    orgin.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy");
            return method.invoke(orgin,args);
        }
    }

    static class AC implements Ant{
        @Override
        public void say() {
            System.out.println("aaa");
        }
    }

    public static void main(String[] args) {
        AC proxyed = new AC();
        Ant proxy = (Ant) new AntProxy().getProxy(proxyed);
        proxy.say();
        System.out.println(proxy);
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", proxyed.getClass().getClasses());
        System.out.println($Proxy0s.length);
        try(FileOutputStream out = new FileOutputStream(new File("E:\\proxy.class"))){
            out.write($Proxy0s);
        }catch (IOException e){
            e.printStackTrace();
        }
        //    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
    }
}
