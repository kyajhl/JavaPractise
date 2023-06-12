package day05;

import java.util.*;

/**
 * @author KeFan
 * @date 2023/4/20
 * @time 11:49
 */

public class JavaDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        int i = stack.search(2);
        System.out.println(i);

        LinkedList<Integer> integers = new LinkedList<>();
        integers.addFirst(2);
        integers.addLast(1);
        Integer peek = integers.peek();
        System.out.println(peek + " " + integers);
        Integer pop = integers.pop();
        System.out.println(pop + " " + integers);

        Queue<Integer> integers1 = new LinkedList<>();
        integers1.add(2);
        integers1.add(1);
        Integer peek1 = integers1.peek();
        System.out.println(peek1 + " " + integers1);
        integers1.offer(1);
        System.out.println(integers1);

        String s = "666";
        System.out.println(1 % 2);
    }

}
