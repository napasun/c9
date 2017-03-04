package study.java.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _11 {
	public enum Caloric {DIET, NORMAL, FAT};
	
	public static void main(String[] args) {
		List<Food> menu = Food.getMenu();
		
		System.out.println(menu.stream().collect(Collectors.counting()));	//갯수
		
		Comparator<Food> com = Comparator.comparingInt(Food::getCalories);
		System.out.println(menu.stream().collect(Collectors.maxBy(com)));	//.get().getName()
		
		System.out.println(menu.stream().collect(Collectors.summingInt(Food::getCalories)));
		
		//그룹
		Map<Food.Type, List<Food>> dt = menu.stream().collect(Collectors.groupingBy(Food::getType));
		System.out.println(dt);
		
		//그룹에 그룹
		Map<Food.Type, Map<Caloric, List<Food>>> ddt = menu.stream()
				.collect(
						Collectors.groupingBy(Food::getType
						, Collectors.groupingBy(food -> {
							if (food.getCalories() < 400)
								return Caloric.DIET;
							else
								return Caloric.NORMAL;
						})
				));
		
		System.out.println(ddt);
		
		
		//분할
		Map<Boolean, List<Food>> ft = menu.stream().collect(Collectors.partitioningBy(Food::isVegetarian));
		System.out.println(ft);
		
		//다운 스트림
		Map<Food.Type, Integer> total = menu.stream().collect(Collectors.groupingBy(Food::getType, Collectors.summingInt(Food::getCalories)));
		
		System.out.println(total);
		
	}
}
