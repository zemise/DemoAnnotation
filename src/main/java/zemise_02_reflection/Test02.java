package zemise_02_reflection;

import javax.annotation.processing.Generated;

/**
 * @Author Zemise_
 * @Date 2023/3/26
 * @Description 什么叫做反射
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的class对象
        Class c1 = Class.forName("zemise_02_reflection.User");
        System.out.println(c1);

        // 一个类在内存中只有一个class对象
        // 一个类被加载后，类的整个结构都会被封装在class对象中
        Class c2 = Class.forName("zemise_02_reflection.User");
        System.out.println(c2.hashCode());
        Class c3 = Class.forName("zemise_02_reflection.User");
        System.out.println(c3.hashCode());
        Class c4 = Class.forName("zemise_02_reflection.User");
        System.out.println(c4.hashCode());

        // 这个是以一个实例对象，返回一个类的对象，可以看到和上述也是一样的
        User user = new User();
        Class c5 = user.getClass();
        System.out.println(c5.hashCode());

    }

}

// 实体类: pojo, entity
class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
}
