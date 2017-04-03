package study.java.stream;

import java.util.Arrays;
import java.util.List;

public class _6 {
	public static void main(String[] args) {
		List<Integer> n = Arrays.asList(1,2,1,3,3,2,4);
		
		n.stream()
			.filter(i -> i % 2 == 0)
			.distinct()
			.forEach(System.out::println);
	}
}
