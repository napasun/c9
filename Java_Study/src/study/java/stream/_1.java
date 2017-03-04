package study.java.stream;
//로깅
import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _1 {
	public static void main(String[] args) {
		List<Food> menu = Food.getMenu(); 
		
		
		List<Food> lowCalorie = new ArrayList<>();
		for (Food d : menu) {
			if (d.getCalories() < 400)	//칼로리가 400이하인 음식
				lowCalorie.add(d);
		}
		
		Collections.sort(lowCalorie, new Comparator<Food>() {	//정렬
			public int compare(Food d1, Food d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		
		List<String> foodName = new ArrayList<>();	 
		for (Food d : lowCalorie) {
			foodName.add(d.getName());	//음식이름 따로 저장
		}
		
		
		
		List<String> lowCalorieFoodName = menu.stream()
				.filter(d -> d.getCalories() < 400)
				.sorted(comparing(Food::getCalories))
				.map(Food::getName)
				.collect(Collectors.toList());	
		
		for(String t : lowCalorieFoodName) {
			System.out.println(t);
		}
	}
}
