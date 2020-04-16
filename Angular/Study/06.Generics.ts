function identity<T>(arg: T): T {
    return arg;
}

let output = identity<string>("myString");
let output2 = identity<number>(1);