//print('hello'.slice(-2));
/**
 * 자바 클래스를 확장하거나 인터페이스를 구현 할 때 Java.extend를 사용한다.
 * */
var RandomIterator = Java.extend(java.util.Iterator, {
	next : function() Math.random(),
	hasNext : function() true
})
var iter = new RandomIterator();

var func1 = function(name) {    
	print("func1 " + iter.next());    
	return "return func1";
}

/**
 * 자바 클래스들은 Java.type API로 자바스크립트에서 호출될 수 있다. 
 * 이것은 자바 코드의 import와 비슷하다. 
 * 자바 타입에 정적으로 fun1이 정의되어 있기 때문에 
 * 우리는 인스턴스를 먼저 생성할 필요가 없다.
 * */
/*var NashornTest = Java.type("study.java.nashorn.NashornStudy");
print(NashornTest.func1("java test"));

var javafunc1 = new NashornTest;

var result = javafunc1.func2("java test");
print(result);*/


/*var ArrayList = Java.type("java.util.ArrayList");
var list = new ArrayList();
list.add("a");list.add("b");list.add("c");
for each (var el in list) print(el);


var list2 = new java.util.ArrayList();
list2.add("ddd2");list2.add("aaa2");
list2.add("bbb1");list2.add("aaa1");
list2.add("bbb3");list2.add("ccc");
list2.add("bbb2");list2.add("ddd1");
list2.stream()
	.filter(function(el) {        
		return el.startsWith("aaa");
	})
	.sorted()
	.forEach(function(el) {
		print(el);
	});*/

