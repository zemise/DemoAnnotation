package zemise_01_annotation;

import java.lang.annotation.*;

/**
 * @Author Zemise_
 * @Date 2023/3/26
 * @Description 测试元注解
 */
public class Test02 {
    @MyAnnotation
    public void test() {

    }
}


// 定义一个注解
// Target 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// Retention 表示我们的注解在什么地方还有效
// runtime > class > sources
@Retention(value = RetentionPolicy.RUNTIME)
// Documented 该注解将被包含在JavaDoc中
@Documented
// Inherited 子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}