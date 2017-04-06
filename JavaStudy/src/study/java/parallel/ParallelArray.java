package study.java.parallel;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class ParallelArray {
	public static void main(String[] args) {
		int[] value = {6,2,7,4,5};
		
		Arrays.parallelSort(value);
		
		for (int v : value) {
			System.out.print(v);
		}
		
		System.out.println("");
		
		Arrays.parallelSetAll(value, v -> v * 2);	//요소 인덱스를 받아서 계산한다.
		
		for (int v : value) {
			System.out.print(v);
		}
		
		System.out.println("");
		
		Arrays.parallelPrefix(value, (v, j) -> v+j);	//v는 초기값 + 그 전 연산 결과 값
		//j는 배열의 값
		
		for (int v : value) {
			System.out.println(v);
		}
		
		
	}
}
