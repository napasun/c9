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