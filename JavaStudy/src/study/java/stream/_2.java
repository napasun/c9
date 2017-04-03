package study.java.stream;

import java.util.List;
import java.util.stream.Stream;

public class _2 {
	public static void main(String[] args) {
		List<Food> menu = Food.getMenu(); 
		Stream<String> f = menu.stream().map(Food::getName);
		
		f.forEach(System.out::println);
		f.forEach(System.out::println);
	}
}
