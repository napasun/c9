let a =10;

// f - 함수 안에서 변수를 선언 할 수도 있습니다
function f() {
    let message = "Hello, world!";
    return message;
}


// f2 - 다른 함수 내에서 동일한 변수에 액세스 할 수도 있습니다.
function f2() {
    let a2 = 10;
    return function g() {
        let b2 = a2 + 1;
        return b2;
    }
}

let g = f2();
g();

// f3 - 내부 함수에서 리턴되는 값은 당시에 캡쳐된 값을 가진다.
function f3() {
    var a4 = 1;

    a4 = 2;
    var b4 = g2();
    a4 = 3;

    return b4;

    function g2() {
        return a4;
    }
}
f3();

//f4
function f4(shouldInitialize: boolean) {
    if (shouldInitialize) {
        var x = 10;
    }

    return x;
}

f4(true);  // returns '10'
f4(false); // returns 'undefined'

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