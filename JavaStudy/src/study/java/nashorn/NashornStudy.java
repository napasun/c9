package study.java.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornStudy {
	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		//자바에서 자바스크립트를 수행하기 위해서 nashorn 스크립트 엔진을 먼저 생성해야 한다.
		ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
		
		try {
			//문자열로 스크립트 실행
			scriptEngine.eval("print('Hello world');");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		
		try {
			//js 파일 불러오기
			scriptEngine.eval(new FileReader("test.js"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 나스호른에서는 자바코드로부터 스크립트 파일에 정의된 자바스크립트 함수를 직접 호출할 수 있다. 
		 * 우리는 자바 오브젝트를 함수의 인자로 전달할 수 있고 함수의 호출결과를 전달 받을 수 있다.
		 * 
		 * 먼저 함수를 호출하기 위해서는 자바 스크립트 엔진을 invocable로 캐스팅해야된다. 
		 * Invocale 인터페이스는 NashornScriptEngine에 구현되어 있으며 
		 * 주어진 이름의 자바스크립트 함수를 호출할 수 있는 invokeFunction 함수가 정의되어 있다.
		 * */
		scriptEngine.eval(new FileReader("2.js"));
		Invocable invocable = (Invocable)scriptEngine;
		Object result = invocable.invokeFunction("func1", "test2");
		
		//System.out.println(result);
		//System.out.println(result.getClass());
	}
	
	
	/**
	 * 자바 스크립트에서 자바 함수 호출하기
	 * */
	public static String func1(String name) {  
		System.out.format("java func1, %s\n", name);
		return "return java func1";
	}
	public String func2(String name) {  
		System.out.format("java func, %s\n", name);
		return "return java func2";
	}
}
