//Boolean
let isCheck: boolean = true;

//Number
let num: number = 11;
let hex: number = 0xaa
let binary: number = 0b0101
let octal: number = 0o456

//String
let str: string = "hello";
let str2: string = 'world';

//Array
let arr: number[] = [1,2,3];
let list: Array<Number> = [1,2,3];

//Tuple
let tup: [String, number] = ["a", 1];
tup[3] = "test"
console.log(tup);

//Enum
enum Color {Red, Green, Blue};
let c: Color = Color.Green;

enum Color2 {Red = 1, Green, Blue};
let c2: Color2 = Color2.Green;

enum Color3 {Red = 1, Green = 2, Blue = 4}
let c3: Color3 = Color3.Green;

//Any : 어떤 유형이든 사용할 수 있음
let notSure: any = 4;
notSure = "maybe a string instead";
notSure = false; // okay, definitely a boolean
// 배열에 여러 유형을 혼합하여 사용할 수 있다.
let anyList: any[] = [1, true, "free"];
anyList[1] = 100;

//void 값을 반환하지 않는 함수유형에 사용
function warnUser(): void {
    alert("This is my warning message");
}
//undefined 또는 null을 넣을 수 있다.
let unusable: void = undefined;
//unusable = 1;

//Null, Undefined
let u: undefined = undefined;
let n: null = null;