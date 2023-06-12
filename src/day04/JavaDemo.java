package day04;

import java.util.*;

/**
 * @author KeFan
 * @date 2023/4/19
 * @time 14:19
 */

public class JavaDemo {

    public static void main(String[] args) {
        int[][] nums = new int[6][3];
        int n = nums.length;
        int m = nums[0].length;

        int[] ans = new int[6];
        ans[0] = 1;
        Arrays.sort(ans);

        String res = "hello world";
        char[] array = res.toCharArray();
        System.out.println(array);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        for (Integer s : set) {
            System.out.println(s);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            Integer value = map.get(key);
            System.out.println(key + " ==> " + value);
        }

        Queue<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer poll = list.poll();
        System.out.println(poll + " " + list.size());

        ArrayList<Integer> list1 = new ArrayList<>();
    }

}
