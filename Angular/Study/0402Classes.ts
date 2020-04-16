/// 클래스 Classes
/*
전통적인 자바 스크립트는 재사용 가능한 구성 요소를 만들기 위해 함수와
프로토 타입 기반 상속을 사용하지만, 클래스가 기능을 상속하고 객체가 
이러한 클래스에서 빌드되는 객체 지향 접근 방식에 익숙하지 않은 프로그래머에게는
다소 부담 스럽습니다. ECMAScript 2015 (ECMAScript 6)로 시작하는 
JavaScript 프로그래머는이 객체 지향 클래스 기반 접근 방식을 사용하여 응용 프로그램을
 빌드 할 수 있습니다. TypeScript에서는 개발자가이 기술을 사용하고 다음 JavaScript 버전을
  기다릴 필요없이 모든 주요 브라우저와 플랫폼에서 작동하는 JavaScript로 컴파일 할 수 있습니다.
 */
///constructor : 생성자
class Greeter {
    greeting: string;
    constructor(message: string) {
        this.greeting = message;
    }
    greet() {
        return "Hello, " + this.greeting;
    }
}

let greeter = new Greeter("world");

///상속
// extends 키워드로 하위 클래스를 만든 다.
class Animal {
    name: string;
    constructor(theName: string) { this.name = theName; }
    move(distanceInMeters: number = 0) {
        console.log(`${this.name} moved ${distanceInMeters}m.`);
    }
}

class Snake extends Animal {
    constructor(name: string) { super(name); }
    move(distanceInMeters = 5) {
        console.log("Slithering...");
        super.move(distanceInMeters);
    }
}



/// Public, private, and protected modifiers
// 기본은 public
// 읽기 전용 readonly

///Accessors 
let passcode = "secret passcode";

class Employee {
    private _fullName: string;

    get fullName(): string {
        return this._fullName;
    }

    set fullName(newName: string) {
        if (passcode && passcode == "secret passcode") {
            this._fullName = newName;
        }
        else {
            console.log("Error: Unauthorized update of employee!");
        }
    }
}