package day07;

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
    }
}
