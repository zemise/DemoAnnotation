package zemise_02_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author Zemise_
 * @Date 2023/3/26
 * @Description 获得类的信息
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("zemise_02_reflection.User");

        // 获得类的名字
        System.out.println(c1.getName()); // 获得包名 + 类名
        System.out.println(c1.getSimpleName()); //获得类名

        User user = new User();
        Class c2 = user.getClass();
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());

        // 获得类的属性
        System.out.println("====================");
        Field[] fields = c1.getFields(); // 只能找到public属性
        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] fields1 = c1.getDeclaredFields(); // 能找到全部属性
        for (Field field : fields1) {
            System.out.println(field);
        }

        // 获得指定属性的值
        System.out.println("====================");
        Field age = c1.getDeclaredField("age");
        System.out.println(age);
        // 获得类的方法
        System.out.println("====================");

        Method[] Methods = c1.getMethods(); // 获得本类及其父类的全部public方法
        for (Method method : Methods) {
            System.out.println(method);
        }

        Method[] declaredMethods = c1.getDeclaredMethods(); // 获的本类的所有方法
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("====================");
        // 获得指定的方法
        // 重载
        Method getName = c1.getMethod("getName", null);
        System.out.println(getName);

        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);

        // 获得指定的构造器
        System.out.println("====================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定" + declaredConstructor);
    }
}
