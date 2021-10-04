package helper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation  {

	public static String checkRegex(String regex, String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		while (true) {
			String str = scanner.nextLine();
			Pattern patter = Pattern.compile(regex);
			Matcher match = patter.matcher(str);
			if (match.matches()) {
				return str;
			}
			else {
				System.out.println("eror:data invalid");
			}
		}
	}

}
