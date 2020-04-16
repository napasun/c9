namespace s11 {

// ECMAScript 2015 에 있는 symbol
// 심볼은 변경 불가능 하며 고유하다(안의 값이 같더라도 같은 게 아니다.)
let sym1 = Symbol();
let sym2 = Symbol("key"); 
let sym3 = Symbol("key");

sym2 === sym3; // false 심볼은 고유하다.



// 심볼은 객체의 속성의 키로 사용할 수 있다.
let sym = Symbol();

let obj = {
    [sym]: "value"
};

console.log(obj[sym]); // "value"


// 객체의 클래스 멤버로도 선언할 수 있다.
const getClassNameSymbol = Symbol();

class C {
    [getClassNameSymbol](){
       return "C";
    }
}

let c = new C();
let className = c[getClassNameSymbol](); // "C"



}