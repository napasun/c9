///printLabel 함수의 매개변수 labelledObj 객체에 label 이라는 문자열 속성이 있는 지 검사한다.
function printLabel(labelledObj: { label: string }) {
    console.log(labelledObj.label);
}
let myObj = {size: 10, label: "Size 10 Object"};
//let myObj = {size: 10, label2: "Size 10 Object"}; //속성 불일치
//let myObj = {size: 10, label: 3};    //타입 불일치
printLabel(myObj);




///인터페이스를 사용해서 구현한 예
// LabelledValue 인터페이스 상에서 string타입을 갖는 label값이 있다고 전달한다.
interface LabelledValue {
    label: string;
}

function printLabel2(labelledObj: LabelledValue) {
    console.log(labelledObj.label);
}

let myObj2 = {size: 10, label: "Size 10 Object"};
printLabel2(myObj2);












///Optional Properties 선택적 속성
// 인터페이스에 속성에 값이 없을 수도 있게 만든다.
// 선택적 속성은 이름 끝에 '?'를 붙인다.
// 선택적 속성은 속성의 사용을 방지하면서 사용 가능한 속성을 명시 할 수 있다.
// 속성 이름을 잘못 사용하였을 경우 오류 메시지를 볼 수 있다.
interface SquareConfig {
    color?: string;
    width?: number;
}

function createSquare(config: SquareConfig): {color: string; area: number} {
    let newSquare = {color: "white", area: 100};
    if (config.color) {
        newSquare.color = config.color;
    }
    if (config.width) {
        newSquare.area = config.width * config.width;
    }
    return newSquare;
}

let mySquare = createSquare({color: "black"});






/// 읽기 전용 속성 Readonly properties 
interface Point {
    readonly x: number;
    readonly y: number;
}

let p1: Point = { x: 10, y: 20 };
//p1.x = 5; // error!






/// 모든 변경 메소드가 제거된 ReadonlyArray<T>
let a: number[] = [1, 2, 3, 4];
let ro: ReadonlyArray<number> = a;
ro[0] = 12; // error!
ro.push(5); // error!
ro.length = 100; // error!
a = ro; // error!





/// 추가 속성 체크 Excess Property Checks
interface SquareConfig {
    color?: string;
    width?: number;
    [propName: string]: any;
}

function createSquare2(config: SquareConfig): { color: string; area: number } {
    config.colour;
    config.width;
    return;
}

let squareOptions = { colour: "red", width: 100 };
createSquare2(squareOptions);





/// 함수 유형 인터페이스 Function Types
// 속성을 가진 객체 외에 함수 유형을 선언할 수 있다.
// 주어진 매개 변수 목록과 반환 유형 만 있는 함수 선언이다.
// 매개 변수 목록의 각 매개 변수에는 이름과 유형을 모두 선언해 주어야 한다.
// 함수를 구현할 때 매개 변수의 이름을 일치시킬 필요는 없다.
interface SearchFunc {
    (source: string, subString: string): boolean;
}
let mySearch: SearchFunc;
mySearch = function(sour: string, subString: string) {
    let result = sour.search(subString);
    return result > -1;
}




/// 인덱싱 가능 유형 Indexable Types
interface StringArray {
    [index: number]: string;
}

let myArray: StringArray;
myArray = ["Bob", "Fred"];

let myStr: string = myArray[0];







/// 클래스 유형
// 인터페이스를 사용하는 이유는 클래스가 특정 조건을 준수하도록 명시하기 위해서 이다.
// implements 을 사용하여 상속한다.
interface ClockInterface {
    currentTime: Date;
    setTime(d: Date);
}

class Clock implements ClockInterface {
    currentTime: Date;
    setTime(d: Date) {
        this.currentTime = d;
    }
    constructor(h: number, m: number) { }
}






/// 인터페이스 확장 Extending Interfaces
// extends 을 사용하여 인터페이스를 확장한다.
interface Shape {
    color: string;
}

interface Square extends Shape {
    sideLength: number;
}

let square = <Square>{};
square.color = "blue";
square.sideLength = 10;