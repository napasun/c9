package java9.list;

import java.util.List;

public class ListStudy {
	public static void main(String[] args) {
		List l = List.of();
		l.add("add");	// 에러 변경 불가능한 리스트
	}
}
