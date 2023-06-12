package day01;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author KeFan
 * @date 2023/4/13
 * @time 17:38
 */

public class JavaDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(11);
        System.out.println(list.pop());

        System.out.println("-----------------------");

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.add(2);
        Integer peek = s.peek();
        System.out.println(s + "," + peek);
        for (Integer x : s) {
            System.out.println(x);
        }
        System.out.println(Integer.MAX_VALUE);
    }
}
