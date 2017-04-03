package study.java.stream;

import java.util.List;
import java.util.stream.Collectors;

public class _7 {
	public static void main(String[] args) {
		List<Food> menu = Food.getMenu();
		
		System.out.println(
		
		menu.stream()
			.filter(d -> d.getCalories() > 300)
			.map(Food::getName)
			.map(String::length)
			.skip(2)
			.collect(Collectors.toList())
		);
	}
}
