package day03;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author KeFan
 * @date 2023/4/16
 * @time 20:56
 */

public class JavaDemo {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        String s = "We are happy.";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') res.append("%20");
            else res.append(c);
        }

        System.out.println(res);

        char[] chars = new char[6];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '3';
        chars[3] = '4';
        chars[4] = '5';
        chars[5] = '6';
        String s1 = new String(chars, 0, 3);
        System.out.println(s1);

        System.out.println("---------------");

        HashSet<Integer> hash = new HashSet<>();
        hash.containsAll(new ArrayList<>());

        HashMap<String, Integer> hash1 = new HashMap<>();
        HashSet<Integer> hash2 = new HashSet<>();

        List<Integer> integers = new ArrayList<Integer>();
    }
}
