public class ConsoleWriter {

	public static void clear() {
		// ANSI escape codes: 
	    // H : move to top of the screen
		// 2J: clear entire screen
		System.out.print("\033[H\033[2J");
	}
	
	public static void clearAndPrintln(String content) {
		ConsoleWriter.clear();
		System.out.println(content);
	}
	
	public static void println(String content) {
		System.out.println(content);
	}
	
}
