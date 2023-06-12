package maze;

import java.util.Arrays;
import java.util.Random;

/**
 * @author KeFan
 * @date 2023/5/13
 * @time 15:20
 */

public class TestMaze {

    public static void main(String[] args) {
//        Random random = new Random();
//        int i = random.nextInt(2);
//        System.out.println(i + " ");
//        double r = random.nextDouble();
//        System.out.println(r + " ");

        int[] p = new int[6];
        p[0] = 1;
        p[1] = 2;
        p[2] = 3;

        int[] t = p;
        t[0] = 2;
        System.out.println(Arrays.toString(p));

    }

}
