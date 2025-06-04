import java.util.Scanner;

public class ConsoleReader {
	private static Scanner scanner = new Scanner(System.in);
	
	public static String readDirection(String lastDirection) {
		String res = null;
		while (res == null) {
			System.out.print("Enter direction" + (lastDirection != null ? " (" + lastDirection + "): " : ":" ));
			String pos = scanner.next();
			if ((pos == null || pos.isBlank()) && (lastDirection != null && !lastDirection.isBlank())) {
				return lastDirection;
			} 
			res = pos;			
		}
		return res;
	}
}
