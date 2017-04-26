package java8.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ListStudy {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		//수정 불가능한 리스트 만들기
		List<String> constList = Collections.unmodifiableList(list);
		
		
		//java8 이전 컬렉션 반복실행 
		for(String str : list) {
			System.out.println(str);
		}
		
		//java8 컬렉션 반복 : forEach 
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String arg0) {
				System.out.println(arg0);
			}
		});
		
		//람다식을 사용해서 코드 줄이기
		list.forEach((str) -> System.out.println(str));
	}
}
