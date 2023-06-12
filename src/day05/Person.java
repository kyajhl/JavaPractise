package day05;

/**
 * @author KeFan
 * @date 2023/4/20
 * @time 14:19
 */

public class Person implements Et, Animal {
    @Override
    public void eat() {
        System.out.println("吃东西");
    }

    @Override
    public void speak() {
        System.out.println("说话");
    }
}
