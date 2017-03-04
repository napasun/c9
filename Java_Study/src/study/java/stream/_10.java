package study.java.stream;

import java.util.List;

public class _10 {
	public static void main(String[] args) {
		List<Food> menu = Food.getMenu();
		
		System.out.println(
			menu.stream().map(Food::getCalories).reduce(0, Integer::sum)
		);
		/*System.out.println(
			menu.stream().map(Food::getCalories).sum()
		);
*/		
		System.out.println(
			menu.stream().mapToInt(Food::getCalories).sum()
		);
		
		System.out.println(
				menu.stream().mapToInt(Food::getCalories).max()	//값이 없을 수 있으므로 op...
		);
	}
}
