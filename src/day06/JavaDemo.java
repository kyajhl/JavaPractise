package day06;

/**
 * @author KeFan
 * @date 2023/5/17
 * @time 14:42
 */

public class JavaDemo {

    public static void main(String[] args) {
        TestDemo demo = new TestDemo(18, "666");
        System.out.println(demo);
    }

}

class TestDemo {
    private Integer age;
    private String name;

    @Override
    public String toString() {
        return "TestDemo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestDemo(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}
