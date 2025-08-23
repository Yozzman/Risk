package pf.yozzman.risk.util;

public class ConsoleWriter {
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearAndPrintln(String content) {
        clear();
        println(content);
    }

    public static void println(String content) {
        System.out.println(content);
    }

    public static void print(String content) {
        System.out.print(content);
    }
}
