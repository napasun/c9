package study.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class _9 {
	public static void main(String[] args) {
		List<Integer> n = Arrays.asList(); //Arrays.asList(1,2,1,3,3,2,4);
		
		/*int sum = 0;
		for (int x : n) {
			sum += x;
		}*/
		
		
		//int sum2 = n.stream().reduce(0, (a, b) -> a + b);
		//System.out.println(sum2);
		
		Optional<Integer> sum3 = n.stream().reduce((a, b) -> a + b);
		
		System.out.println(sum3.get());
		
		n.stream().reduce(Integer::max);
		
		n.stream().reduce(Integer::min);
	}
}
