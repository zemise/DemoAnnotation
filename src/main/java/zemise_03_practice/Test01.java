package zemise_03_practice;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @Author Zemise_
 * @Date 2023/3/26
 * @Description 练习反射操作注解
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("zemise_03_practice.Student2");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 获得注解的value的值
        TableZemise tableZemise = (TableZemise) c1.getAnnotation(TableZemise.class);
        String value = tableZemise.value();
        System.out.println(value);

        // 获得类指定的注解
        Field f = c1.getDeclaredField("id");
        FiledZemise annotation = f.getAnnotation(FiledZemise.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }

}

@TableZemise("db_studet")
class Student2{
    @FiledZemise(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FiledZemise(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FiledZemise(columnName = "db_name", type = "varchar", length = 10)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}



// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableZemise{
    String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FiledZemise{
    String columnName();
    String type();
    int length();
}