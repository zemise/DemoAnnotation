package zemise_02_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Zemise_
 * @Date 2023/3/26
 * @Description 动态的创建对象，通过反射
 */
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        // 获得Class对象
        Class c1 = Class.forName("zemise_02_reflection.User");
        // 构造一个对象
        User user = (User) c1.newInstance(); // 本质是调用类无参构造器
        System.out.println(user);


        // 通过构造器创建对象
        Constructor con = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User zemise_ = (User) con.newInstance("zemise_", 1, 19);
        System.out.println(zemise_);


        System.out.println("=========================");
        // 通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "abc");
        System.out.println(user3.getName());

        // 通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        // 不能直接操作私有属性，我们需要设置暴力反射，赋值为true
        name.setAccessible(true); // 暴力反射私有属性
        name.set(user4,"zemise_");
        System.out.println(user4.getName());

    }
}
