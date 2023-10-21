package zemise_01_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Zemise_
 * @Date 2023/3/26
 * @Description 自定义注解
 */
public class Test03 {
    // 注解可以显示赋值，如果没有默认值，就必须给注解赋值
    @MyAnnotation2(name = "zemise_", school = {"北京大学", "北京"})
    public void test() {

    }

    @MyAnnotation3("zemise_")
    public void  test03(){

    }
}

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数 ： 参数类型 + 参数名();
    String name() default "";

    int age() default 0;

    int id() default -1; // 如果默认值为-1，代表不存在。和indexof类似，如果找不到就返回-1
    String[] school() default {"清华大学", "清华"};
}


@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value(); //注解如果只有一个值，建议写value，只有value才可以省去默认值
}
