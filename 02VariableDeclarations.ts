let a =10;

//
function f() {
    let message = "Hello, world!";
    return message;
}


//
function f2() {
    let a2 = 10;
    return function g() {
        let b2 = a2 + 1;
        return b2;
    }
}

let g = f2();
g();


///let
//블록 범위 지정
function letScope(input: boolean) {
    let a3 = 100;

    if (input) {
        // Still okay to reference 'a'
        let b3 = a3 + 1;
        return b3;
    }

    // Error: 'b' doesn't exist here
    return b3;
}

//재선언
let x = 10;
let x = 20;

///const
//상수 선언

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
let [first] = [1, 2, 3, 4];
console.log(first); // outputs 1
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