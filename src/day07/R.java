package day07;

/**
 * @author KeFan
 * @date 2023/7/23
 * @time 14:41
 */

public class R {
    public R () {
        printOk();
        printError();
    }

    public void printOk() {
        System.out.println("ok");
    }

    public void printError() {
        System.out.println("error");
    }

    public static R getR() {
        return new R();
    }
}
