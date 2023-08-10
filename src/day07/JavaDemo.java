package day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author KeFan
 * @date 2023/6/12
 * @time 0:30
 */

public class JavaDemo {

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";

        System.out.println(a + "---" + b);

        a = "def";

        System.out.println(a + "---" + b);

//        new R().printOk();

        R.getR().printOk();

        User user1 = new User("aaa", 10);
        User user2 = new User("bbb", 20);
        User user3 = new User("ccc", 30);

        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        List<User> list1 = list.stream().peek(user -> user.setName("qwe")).collect(Collectors.toList());
        List<String> list2 = list.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(list1);
        System.out.println(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        List<Integer> integerList = list3.stream().map(item -> {
            return 3;
        }).collect(Collectors.toList());
        System.out.println(integerList);
    }
}