package study.java.stream;

import java.util.Arrays;
import java.util.List;

public class Food {
	String name;
	boolean vegetarian;
	int calories;
	Type type;
	
	public enum Type {
		MEAT, FISH, OTHER;
	}

	public Food(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	static public List<Food> getMenu() {
		List<Food> menu =  Arrays.asList(
				new Food("돼지고기", false, 800, Type.MEAT)
				, new Food("소고기", false, 700, Type.MEAT)
				, new Food("닭고기", false, 400, Type.MEAT)
				, new Food("채소", false, 500, Type.OTHER)
				, new Food("밥", false, 350, Type.OTHER)
				, new Food("소금", false, 100, Type.OTHER)
				, new Food("피자", false, 550, Type.OTHER)
				, new Food("새우", false, 300, Type.FISH)
				, new Food("연어", false, 450, Type.FISH));
		
		return menu;
	}
	
}
