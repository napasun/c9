package study.java.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMap {
	public static void main(String[] args) {
		Stream<String[]> arr = Stream.of(new String[]{"abc", "def", "ghi" },
				new String[]{"123", "456", "789"});
		
		Stream<String> str = arr.flatMap(Arrays::stream);
		
		str.forEach(System.out::println);
	}
}
