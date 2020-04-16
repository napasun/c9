package study.java.stream;

import java.util.List;

import study.java.stream.Food.Type;

public class _8 {
	public static void main(String[] args) {
		List<Food> menu = Food.getMenu();
		
		System.out.println(menu.stream().anyMatch(Food::isVegetarian));
		
		System.out.println(menu.stream().allMatch(d -> d.getCalories() < 300));
		System.out.println(menu.stream().allMatch(d -> d.getCalories() < 1000));
		
		System.out.println(menu.stream().filter(Food::isVegetarian).findAny());
		System.out.println(menu.stream().filter(Food::isVegetarian).findAny().isPresent());
		menu.stream().filter(Food::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
		System.out.println(menu.stream().filter(Food::isVegetarian).findAny().get().getName());
		
		System.out.println(menu.stream().filter(d -> d.getCalories() < 100).findAny());
		System.out.println(menu.stream().filter(d -> d.getCalories() < 100).findAny().orElse(new Food("설탕", true, 50, Type.OTHER)).getName());
	}
}
