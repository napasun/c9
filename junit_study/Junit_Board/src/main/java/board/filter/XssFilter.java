package board.filter;

public class XssFilter {
	public static String convert(String content) {
		return content.replaceAll("<", "&lt;");
	}
}
