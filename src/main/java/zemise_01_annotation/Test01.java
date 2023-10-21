package zemise_01_annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zemise_
 * @Date 2023/3/26
 * @Description 什么是内置注解
 */
public class Test01 {
    // Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // Deprecated 不推荐程序员使用，但是可以使用，或者存在更好的方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }


    // SuppressWarnings 镇压警告，可以放在方法上、类上等
    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        Test01.test();
    }

}
