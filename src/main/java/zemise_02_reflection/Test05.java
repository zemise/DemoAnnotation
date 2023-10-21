package zemise_02_reflection;

/**
 * @Author Zemise_
 * @Date 2023/3/26
 * @Description 类是怎么加载的
 */
public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m);

        /*
        1、加载到内存，会产生一个类对应的class对象
        2、链接，链接结束后会产生 m = 0
        3、初始化：
            <clinit>() {
                 System.out.println("A类静态代码块初始化");
                 m = 300;
                 m = 100;
            }

            m = 100;
         */
    }
}

class A {
    // 这里按照我的理解
    // 先加载无参构造
    // 静态是由上往下加载
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    /*
    m = 300
    m = 100
     */

    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}
