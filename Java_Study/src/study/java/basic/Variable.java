package study.java.basic;

/**
 * @author khj
 * @since 2015-12-30
 * @category JAVA
 * @deprecated 자바 변수
 * */
public class Variable {
	/**
	 * 값을 저장하는 
	 * 지역 변수(local variables)
	 * 매개 변수(parameters)
	 * 인스턴스 변수(instance variables)
	 * 클래스 변수(class variables) : 메소드 밖, 클래스 안에 선언 static 예약어, 프로그램이 끝날 때 소멸
	 * 변수 생명주기
	 * */
	
	int a;	//인스턴스 변수
	static int b;	//클래스 변수
	
	public static void main(String[] args/*매개변수*/) {
		int c;	//지역 변수
	}
}
