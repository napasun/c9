function s1() {
//타입스크립트는 변수에 맞는 타입을 같이 선언해준다.
//타입에 맞는 값이 아닐 경우 에러가 난다.
//let 변수명 : 타입;
let varName : string;
let twoType : string | number;



//varName = 1;
//Type '1' is not assignable to type 'string'




//let은 블록 스코프를 가진다.
function varScope() {
    var b = 1;

    if (true) {
        var c = 2;
        console.log(b);  // 1
    }
    console.log(c); // 2 : 함수 안에서라면 어디서든 접근이 가능하다.
}

function letScope() {
    let b = 1;

    if (true) {
        let c = 2;
        console.log(b);  // 1
    }
    console.log(c); // Uncaught ReferenceError: c is not defined
}


///재선언
var a = 0;
var a = 1; // a = 1

let d = 2;
let d = 3; //Uncaught SyntaxError: Identifier 'd' has already been declared




///문자열
// ` 백틱 문자인을 사용해서 템플릿 문자열을 사용할 수 있다.
let multi_line2: string =`
one = 1
two = 2
`
console.log(multi_line2);
/*
one = 1
two = 2
*/





///배열 해제할당
let input = [1, 2];
let [first, second] = input;
console.log(first); // outputs 1
console.log(second); // outputs 2

//예전
first = input[0];
second = input[1];
//swap
[first, second] = [second, first];

//함수 매개변수로 사용
function f4([first, second]: [number, number]) {
    console.log(first);
    console.log(second);
}
f4([1, 2]);





/// ... 연산
let [one, ...rest] = [1, 2, 3, 4];
console.log(one); // outputs 1
console.log(rest); // outputs [ 2, 3, 4 ]
//
let [first2] = [1, 2, 3, 4];
console.log(first2); // outputs 1
//
let [, second, , fourth] = [1, 2, 3, 4];




/// 객체 해제할당
let o = {
    a: "foo",
    b: 12,
    c: "bar"
};
let { a, b } = o;
({ a, b } = { a: "baz", b: 101 });








}