let a =10;

//
function f() {
    let message = "Hello, world!";
    return message;
}


//
function f2() {
    let a3 = 10;
    return function g() {
        let b3 = a3 + 1;
        return b3;
    }
}

let g = f2();
g();