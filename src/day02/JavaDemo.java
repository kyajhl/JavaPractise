package day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author KeFan
 * @date 2023/4/14
 * @time 16:47
 */

public class JavaDemo {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int size = list.size();

        for (int i = 0;i < size;i ++) System.out.println(list.get(i));

        Collections.reverse(list);
        System.out.println(list);

        Stack<Integer> s = new Stack<>();
        s.push(1);
        int size1 = s.size();
        System.out.println(s + "," + size1);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("666", 3);
        boolean flag = map.containsKey("666");
        System.out.println(flag);
    }
}
