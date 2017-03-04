package study.java.stream;

import java.util.List;
import java.util.stream.Collectors;

public class _4 {
	public static void main(String[] args) {
		List<Food> menu = Food.getMenu();
		
		List<String> names = menu.stream()
				.filter(d -> {
					System.out.println("filter " +d.getName());
					return d.getCalories() > 300;
				})
				.map(d -> {
					System.out.println("map " + d.getName());
					return d.getName();
				})
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println(names);
	}
}
