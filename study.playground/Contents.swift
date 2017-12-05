//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"

//배열   let로 선언하면 상수배열
var names: Array<String> = ["a", "b", "c", "d"]
//var names: [String]

//빈배열 생성
var emptyArray: [Any] = [Any]()

print(emptyArray.isEmpty)
print(names.count)


print(names[2])
names[2]="e"
print(names[2])
names.append("f")
names.append(contentsOf: ["h", "i"])
names.insert("z", at: 2)
print(names)
print(names.first)
print(names.last)
print(names[1 ... 4])

//순환열거형 indirect 키워드 사용

indirect enum ArithmeticEpression {
    case number(Int)
    case addition(ArithmeticEpression, ArithmeticEpression)
    case multiplication(ArithmeticEpression, ArithmeticEpression)
}

func evaluate(_ expression: ArithmeticEpression) -> Int {
    switch expression {
    case .number(let value) :
        return value
    case .addition(let left, let right) :
        return evaluate(left) + evaluate(right)
    case .multiplication(let left, let right):
        return evaluate(left) * evaluate(right)
    }
}


let 직급: String = "사원"
let 연차: Int = 1
let 인턴인가: Bool = false

switch 직급 {
case "사원" where 인턴인가 == true:
    print("인턴")
case "사원" where 연차 < 2 && 인턴인가 == false:
    print("신입")
default:
    print("사장")
}


//for 임시상수 in 시퀀스 아이템

for i in 0...2 {
    print(i)
}




typealias MoveFunc = (Int) -> Int

func goRight(currentPosition: Int) -> Int {
    return currentPosition + 1
}

func goLeft (currentPosition: Int) -> Int {
    return currentPosition - 1
}

func functionForMove(_ shouldGoLeft: Bool) -> MoveFunc {
    return shouldGoLeft ? goLeft : goRight
}

var position: Int = 3

let moveToZero: MoveFunc = functionForMove(position > 0)


/**
 옵셔널
 */
var myName: String = "yagom"
//myName = nil //오류
//옵셔널 변수 같은 경우 ?를 붙인다.
var myName2: String? = "yagom"
myName2 = nil
print(myName2)


//optional의 경우 값이 없을 경우는 none케이스가 되고 값이 있을 경우는 some 케이스가 된다.
func checkOptionalValue(value optionalValue: Any?) {
    switch optionalValue {
    case .none:
        print("nil")
    case .some(let value):
        print("value = \(value)")
    }
}

var myName3: String? = "yagom"
checkOptionalValue(value: myName3)

myName3 = nil
checkOptionalValue(value: myName3)

let numbers: [Int?] = [2, nil, -4, nil, 100]

for number in numbers {
    switch number {
    case .some(let value) where value < 0:
        print("Ne value = \(value)")
    case .some(let value) where value > 10:
        print("La value = \(value)")
    case .some :
        print("value = \(number)")
    case .none :
        print("nil")
    }
}

//옵셔널 강제 추출 !를 붙여주면 된다. 값이 없다면 런타임 오류가 발생한다.
//var yagom: String = myName3! //런타입 오류

//옵셔널 바인딩
if let name = myName3 {
    print("myname = \(name)")
}
else {
    print("nil")
}

//암시적 추출 옵셔널
//타입 뒤에 !를 사용하면 된다. 해당 값은 일반 값처럼 사용할 수 있으며 nil값도 할당 할 수 있다. nil값이 할당되어 있을 때 사용하면 오류가 발생한다. 옵셔널 바인딩에 사용 가능하다.

/**
 구조체와 클래스
 구조체는 값타입
 클래스는 참조타입
 
 다른점
 구조체는 상속할 수 없다.
 타입캐스팅은 클래스 인스턴스만 가능
 디이니셜라이저는 클래스의 인스턴스에만 활용할 수 있다.
 참조횟수계산은 클래스의 인스턴스에만 적용
 */

//구조체는 struct 키워드로 정의한다.
struct BasicInformation {
    var name: String
    var age: Int
}

var yagomInfo: BasicInformation = BasicInformation(name: "yagom", age: 99)
yagomInfo.age = 100


//클래스
class Person {
    var height: Float = 0.0
    var weight: Float = 0.0
    
    deinit { //클래스 인스턴스가 더이상 참조할 필요가 없을 경우 메모리에서 해제 되는 데 이 때 deinit 함수가 호출된다.
        print("person 클래스 소멸")
    }
}

var p : Person? = Person()
p?.height = 12.1
let p2 = Person()
p2.height = 100.3 //참조 타입이기 때문에 상수 let로 선언해도 내부 프로퍼티 값을 변경할 수 있다.

p = nil


print (p === p2) // 식별연산자 클래스의 인스턴스가 같은 참조를 가리키고 있는 지 확인
//스위프트의 기본 데이터 타입은 모두 구조체이다.


/**
 프로퍼티와 메서드
 프로퍼티는 클래스, 구조체 또는 열거형 등에 관련된 값을 뜻한다. 메서드는 특정 타입에 관련된 함수를 뜻한다.
 */

/**
 프로퍼티
 저장프로퍼티, 연산프로퍼티, 타입프로퍼티
 저장프로퍼티 : 인스턴스의 변수 또는 상수
 연산프로퍼티 : 특정 연산을 실행한 결과값
 프로퍼티의 값이 변하는 것을 감시하는 프로퍼티 감시자도 있다. 값이 변할 때 특정 액션을 실행한다.
 */

//저장 프로퍼티 - 클래스 또는 구조체의 인스턴스와 연관된 값을 저장하는 프로퍼티 var 키워드를 사용하여 변수 저장 프로퍼티, let 키워드를 사용하여 상수 저장 프로퍼티가 될 수 있다.
// 기본값을 지정할 수 있다.

struct CoordinatePoint {
    var x: Int = 0 //저장 프로퍼티
    var y: Int = 0
}

let c: CoordinatePoint = CoordinatePoint(x:10, y:5)//구조체는 기본적으로 저장 프로퍼티를 매개변수로 갖는 이니셜라이저가 있다.

class Position {
    var point: CoordinatePoint //저장 프로퍼티 (변수)
    let name: String //저장 프로퍼티 (상수)
    //프로퍼티 기본값을 지정해주지 않는 다면 이니셜라이저를 따로 정의해주어야 한다.
    init(name: String, currentPoint: CoordinatePoint) {
        self.name = name
        self.point = currentPoint
    }
}

//사용자 정의 이니셜라이저를 호출해야 한다. 그렇지 않으면 프로퍼티 초기값을 할당할 수 없기 때문에 인스턴스를 생성할 수 없다.
//구조체는 프로퍼티에 맞는 이니셜라이저를 자동으로 제공하지만 클래스는 그렇지 않다.
//초기값을 지정했다면 굳이 초기값을 넘길 필요가 없다.

class Position2 {
    var point: CoordinatePoint? //값을 할당하지 않아도 된다.
    let name: String
    
    init(name: String) {//이름은 필수지만 위치는 모를 수 있다.
        self.name = name
    }
}

//지연저장 프로퍼티 lazy 키워드를 사용한다. 호출이 있어야 값을 초기화한다.
//클래스 인스턴스의 저장 프로퍼티로 다른 클래스 인스턴스나 구조체 인스턴스를 할당되어 있을 때 초기화를 하면 한번에 생성된다. 이 때 모든 저장 프로퍼티를 사용할 필요가 없다면 지연저장프로퍼티를 사용한다.
//지연 저장 프로퍼티를 잘 사용하면 불필요한 성능저하나 공간 낭비를 줄일 수 있다.
class lazyPosition {
    lazy var point: CoordinatePoint = CoordinatePoint()
    let name: String
    
    init(name: String) {
        self.name = name
    }
}

let lazyyagomPosition: lazyPosition = lazyPosition(name: "test")
print(lazyyagomPosition.point)  //이 코드를 통해 프로퍼티에 처음 접근할 때 CoordinatePoint가 생성된다.

//연산 프로퍼티 - 특정 상태에 따른 값을 연산하는 프로퍼티
struct CoordinatePoint2 {
    var x: Int
    var y: Int
    
    var oppositePoint : CoordinatePoint2 {  //연산 프로퍼티
        get {   //접근자
            return CoordinatePoint2(x:-x, y:-y)
        }
        set (opposite){ //설정자   읽기 전용으로 만들 경우는 설정자를 빼면 된다.
            x = -opposite.x
            y = -opposite.y
        }
    }
}
var lazy2Position : CoordinatePoint2 = CoordinatePoint2(x:10, y:20)
print(lazy2Position.oppositePoint)  //저장 프로퍼티인 것처럼 편하게 사용할 수 있다.

//프로퍼티 감시자 - 프로퍼티 감시자는 프로퍼티의 값이 새로 할당될 때마다 호출된다. 현재의 값과 같더라도 호출된다.
//지연 저장 프로퍼티에는 사용할 수 없다.
//재정의를 통해 상속받은 저장 프로퍼티 또는 연산 프로퍼티에도 적용할 수 있다.
//프로퍼티 값이 변경되기 전에 호출되는 willSet 메서드와 값이 변경된 후 호출하는 didSet 메서드가 있다.
//willSet, didSet 메서드에는 매개변수가 하나씩 있다. willSet 메서드에 전달되는 전달인자는 변경될 값이고 didSet 메서드에 전달되는 전달인자는 변경되기 전의 값이다.
//매개변수의 이름을 따로 지정하지 않는 다면 willSet 메서드는 newValue, didSet 메서드는 oldValue 가 매개변수 이름으로 지정된다.

class A {
    var credit: Int = 0 {
        willSet {
            print("credit = \(credit), newValue = \(newValue)")
        }
        didSet {
            print("oldValue = \(oldValue), credit = \(credit)")
        }
    }
}

let myA: A = A()
myA.credit = 1000

//타입 프로퍼티 static


// 키 경로 타입
//WritableKeyPath 값 타입에 키 경로 타입으로 읽고 쓸 수 있는 경우에 적용 ReferenceWritableKeyPath 타입은 참조 타입
print (type(of: \A.credit))

let keyPath = \A.credit
print(keyPath)
print(myA[keyPath:keyPath])

//인스턴스 메서드 - 인스턴스 내부의 프로퍼티값을 변경하거나 특정 연산 결과를 반환하는 등 인스턴스와 관련된 기능을 실행한다.
//클래스의 인스턴스 메서드는 상관없지만 구조체나, 열거형 등 값 타입은 메서드 앞에 mutating 키워드를 붙여서 해당 메서드가 인스턴스 내부의 값을 변경한다는 것을 명시해야 한다.

struct LevelStruct {
    var level: Int = 0 {
        didSet {
            print("Level \(level)")
        }
    }
    
    mutating func levelUp() {
        print ("Level Up")
        level += 1
    }
}

var levelStructInstance : LevelStruct = LevelStruct()
levelStructInstance.levelUp()

// self 프로퍼티 - 모든 인스턴스는 암시적으로 생성된 self 프로퍼티를 갖는 다. 인스턴스 자기 자신을 가리킨다.


/**
 인스턴스 생성 및 소멸
 인스턴스 생성
 초기화 과정은 새로운 인스턴스를 사용할 준비를 하기 위하여 저장 프로퍼티의 초기값을 설정하는 일
 이니셜라이저를 정의하면 초기화 과정을 구현할 수 있다.
 이니셜라이저는 func 키워드를 사용하지 않고 오로지 init 키워드를 사용한 메서드이다.
 구조체와 클래스의 인스턴스는 처음 생성할 때 옵셔널 저장 프로퍼티를 제외한 모든 저장 프로퍼티에 초기값을 할당해야 한다.
 프로퍼티를 정의할 때 프로퍼티 기본값을 할당하면 이니셜라이저에서 따로 초기값을 할당하지 않아도 된다.
 */

//옵셔널 프로퍼티 타입
//옵셔널로 선언한 저장 프로퍼티는 초기화 과정에서 값을 할당해 주지 않는 다면 자동으로 nil이 할당된다.

//상수 프로퍼티
//상수로 저장된 저장 프로퍼티는 초기화 과정에서만 값을 할당할 수 있으면 값을 변경할 수 없다.

//초기화 위임 - 값 타입에서 이니셜라이저가 다른 이니셜라이저를 호출하려면 self.init을 사용한다.
//self.init은 이니셜라이저 안에서만 사용할 수 있다.

enum Student {
    case elementary, middle, high
    case none
    
    init() {
        self = .none
    }
    
    init(koreanAge: Int) {
        switch koreanAge {
        case 8...13:
            self = .elementary
        case 14...16:
            self = .middle
        case 17...19:
            self = .high
        default:
            self = .none
        }
    }
    
    init(bornAt: Int, currentYear: Int) {
        self.init(koreanAge: currentYear - bornAt + 1)
    }
}
print(Student(koreanAge: 16))
print(Student(bornAt: 1998, currentYear: 2016))

//실패 가능한 이니셜라이저
//포로퍼티를 옵셔널로 설정하고 에러가 날 경우 nil을 리턴한다.

//클로져를 통한... 213 보류

//인스턴스 소멸
//디이니셜라이저를 구현 클래스 인스턴스가 메모리에서 소멸되기 직전에 호출된다.  deinit
//클래스의 인스턴스에만 구현할 수 있다. 스위프트는 인스턴스가 필요없으면 자동으로 메모리에서 소멸시킨다.
//외부자원을 사용한 경우 닫아주는 부가 작업을 해야하는 데 디이니셜라이저가 사용된다.

class deinitClass {
    deinit {
        print("deinit")
    }
}

var instancd: deinitClass? = deinitClass()
instancd = nil

/**
 접근제어
 스위프트의 접근제어는 모듈과 소스파일을 기반으로 설계되어있다.
 모듈은 배포할 코드의 묶음. 통상 하나의 프레임워크나 라이브러리 또는 애플리케이션이 모듈 단위가 될 수 있다.
 import 키워드를 사용해 불러온다.
 
 접근수준
 open         모듈 외부까지   개방 접근수준(p229 public와의 차이점)
 public       모듈 외부까지   공개 접근수준
 internal     모듈 내부
 fileprivate  파일 내부
 private      기능 정의 내부
 */

//읽기 전용 구현
//설정자만 더 낮은 접근 수준을 갖도록 제한 할 수 있다. 접근수준 키워드 뒤에 [접근수준(set)] 처럼 표현하면 된다.
public struct someType {
    public private(set) var publicGetOnlyStoredProperty: Int = 0 //설정자는 비공개
}

/**
 -- 함수형 프로그래밍과 스위프트 --
 
 클로저
 람다와 유사
 */
let namesc: [String] = ["wizplan", "eric", "yagom", "jenny"]

func backwards(first: String, second: String) -> Bool {
    print("\(first) \(second) 비교중")
    return first > second
}

let reversed: [String] = namesc.sorted(by: backwards)
print(reversed)

/**
 {(매개변수들) -> 반환 타입 in
    실행코드
 }
 클로저는 매개변수 기본값을 사용할 수 없다.
 */
print(namesc.sorted(by: {(first:String, second: String) -> Bool in return first > second}))
print(namesc.sorted {(first:String, second: String) -> Bool in return first > second})  //메서드의 소괄호 생략 가능
print(namesc.sorted {(first, second) -> Bool in return first > second})  //문맥을 이용한 타입 유추

//연산자 함수
/**
 public func > <T: Comparable>(lhs: T, rhs T) -> Bool
 > 라는 이름을 가진 함수
 */
print(namesc.sorted(by: >))  //연산자 함수 적용


/**
 값 획득
 주변에 정의한 상수나 변수가 더 이상 존재하지 않더라도 해당 상수나 변수의 값을 자신 내부에서 참조하거나 수정할 수 있다.
 클로저를 통해 비동기 콜백을 작성하는 경우, 현재 상태를 미리 획득해두지 않으면, 실제로 클로저의 기능을 실행하는 순간에는 주변의 상수나 변수가 이미 메모리에 존재하지 않는 경우가 발생한다.
 */
func makeIncrementer(forIncrement amount: Int) -> (() -> Int) { //함수의 반환 타입은 () -> Int  함수 객체이다.
    var runningTotal = 0
    func incrementer() -> Int { //incrementer 함수는 어떤 매개변수도 갖지 않으며 runningTotal 이라는 변수가 어디 있는 지 찾아 볼 수도 없다.
        //참조를 획득하면 makeIncrementer 함수가 종료되어도 사라지지 않는 다.
        runningTotal += amount
        return runningTotal
    }
    return incrementer
}

let incrementByTwo: (() -> Int) = makeIncrementer(forIncrement: 2)

print(incrementByTwo())
print(incrementByTwo())
print(incrementByTwo())

//클로저는 참조 타입

//탈출 클로저
//함수의 전달인자로 전달한 클로저가 함수 종료 후에 호출될 때 클로저가 함수를 탈출한다고 표현한다.
//클로저를 매개변수로 갖는 함수를 선언할 때 매개변수 이름의 콜론(:) 뒤에 @escaping 키워드를 사용하여 클로저가 탈출하는 것을 허용한다고 명시해줄 수 있다.
//기본은 비탈출 클로저

var completionHandlers: [() -> Void] = []

func someFunctionWithEscapingClosure(completionHandler: @escaping () -> Void) {
    completionHandlers.append(completionHandler)
}

typealias VoidVoidClosure = () -> Void

let firstClosure: VoidVoidClosure = {
    print("C A")
}
let secondClosure: VoidVoidClosure = {
    print("C B")
}

func returnOneClosure(first: @escaping VoidVoidClosure, second: @escaping VoidVoidClosure, shouldReturnFirstClosure: Bool) -> VoidVoidClosure {
    //전달인자로 전달받은 클로저를 함수 외부로 다시 반환하기에 탈출하는 클로저이다.
    return shouldReturnFirstClosure ? first : second
}
// 함수에서 반환한 클로저가 함수 외부의 상수에 저장되었다.
let returnedClosure: VoidVoidClosure = returnOneClosure(first: firstClosure, second: secondClosure, shouldReturnFirstClosure: true)

returnedClosure()

var closures: [VoidVoidClosure] = []

func appendClosure(closure: @escaping VoidVoidClosure) {
    //전달인자로 전달받은 클로저가 외부 변수 내부에 저장되므로 함수를 탈출한다.
    closures.append(closure)
}


func functionWithNoescapeClosure(closure: VoidVoidClosure) {
    closure()
}

func functionWithEscapingClosure(completionHandler: @escaping VoidVoidClosure) -> VoidVoidClosure {
    return completionHandler
}

class SomeClass {
    var x = 10
    
    func runNoescapeClosure() {
        functionWithNoescapeClosure {x = 200 }  //비탈출 클로저에서 self 키워드 사용은 선택 사항이[
    }
    
    func runEscapingClosure() -> VoidVoidClosure {
        return functionWithEscapingClosure {
            //탈출 클로저에서는 명시적으로 self를 사용해야 한다.
            self.x = 100
        }
    }
}

/**
 옵셔널 체이닝과 빠른종료
 중첩된 옵셔널 중 하나라도 값이 존재하지 않으면 nil을 반환한다.
 */

class Room {
    var number: Int
    
    init(number: Int) {
        self.number = number
    }
}

class Building {
    var name: String
    var room: Room?
    
    init(name: String) {
        self.name = name
    }
}

struct Address {
    var province: String
    var city: String
    var street: String
    var building: Building?
    var detailAddress: String?
}

class Person14 {
    var name: String
    var address: Address?
    
    init(name: String) {
        self.name = name
    }
}

let yagom14: Person14 = Person14(name: "yagom")
print("\(yagom14.address?.building?.room?.number)")

if let roomNumber: Int = yagom14.address?.building?.room?.number {
    print(roomNumber)
} else {
    print("Can not find room number")
}

yagom14.address?.building?.room?.number = 100
print(yagom14.address?.building?.room?.number)  //address의 프로퍼티가 없기 때문에 중간에 멈춤

//옵셔널 체이닝을 통한 값 할당
yagom14.address = Address(province: "c", city: "d", street: "e", building: nil, detailAddress: nil)
yagom14.address?.building = Building(name: "f")
yagom14.address?.building?.room = Room(number: 200)

print(yagom14.address?.building?.room?.number)


//빠른 종료 guard
/**
 guard Bool 타입 값 else {
    예외사항 실행문
    제어문 전환 명령어
 }\
 */
//맵
let numbers_15: [Int] = [1,2,3,4]
var doubledNumbers: [Int] = [Int]()

doubledNumbers = numbers_15.map({(number : Int) -> Int in return number * 2})

print(doubledNumbers)

//필터
print(numbers_15.filter({(number: Int) -> Bool in return number % 2 == 0}))

//리듀스
var sum:Int = numbers_15.reduce(0, {(result: Int, element: Int) -> Int in
    print("\(result) + \(element)")
    return result + element
})
print("\(sum)")

/**
 이니셜라이저
 지정 이니셜라이저, 편의 이니셜라이저
 1. 자식클래스의 지정 이니셜라이저는 부모클래스의 지정 이니셜라이저를 반드시 호출해야 한다.
 2. 편의 이니셜라이저는 자신을 정의한 클래스의 다른 이니셜라이저를 반드시 호출해야 한다.
 3. 편의 이니셜라이저는 궁극적으로는 지정 이니셜라이저를 반드시 호출해야 한다.
 
 */

/**
 타입캐스팅
 암시적 데이터 타입 변환을 지원하지 않는 다.
 
 var convertedValue: Int = 5
 convertedValue = 5.5 // 에러
 */

/**
 다운 캐스팅
 타입캐스트 연산자 as? as! 두가지가 있다. 타입캐스트 연산자를 사용하여 자식클래스 타입으로 다운캐스팅할 수 있다.
 다운캐스팅을 시도해보는 조건부 연산자 as? 연산자는 다운캐스팅이 실패했을 경우 nil을 반환하고
 다운캐스팅을 강제하는 as! 연산자는 다운캐스팅이 실패했을 경우 런타임 오류가 발생한다.
 */

/**
 프로토콜 - 특정 역할을 하기 위한 메서드, 프로퍼티, 기타 요구사항 등의 청사진을 정의한다.
 구조체, 클래스, 열거형은 프로토콜을 채택해서 특정 기능을 실행하기 위한 프로토콜의 요구사항을 실제로 구현할 수 있다.
 프로토콜은 정의를 하고 제시를 할 뿐 스스로 기능을 구현하지는 않는 다.
 
 protocal 프로토콜 이름 {
    프로토콜 정의
 }
 
 타입 이름 뒤에 콜론을 붙여준 후 채택할 프로토콜 이름을 쉼표로 구분하여 명시한다.
 class  className: AProtocol, BProtocol {
다른 클래스를 상속 받는 다면 상속받을 클래스 이름 다음에 채택할 프로토콜을 나열한다.
 }
 */

protocol SomeProtocol {//어떤 프로포티를 구현해야 하는 지 요구할 수 있다. 프로퍼티 종류까지는 신경 쓰지 않는 다.
    var settableProperty: String {get set}  //프로퍼티가 읽기 전용인지 읽고 쓰기가 모두 가능한 지는 프로토콜이 정해야 한다.
    var notNeedToBeSettableProperty: String {get}
}

protocol AntherProtocol { //static 상속 불가능한
    static var someTypeProperty: Int {get set}
    static var antotherTypeProperty: Int {get}
}


protocol Sendable {
    var from: String {get}
    var to: String{get}
}

class Message: Sendable {
    var sender: String
    var from: String {
        return self.sender
    }
    var to: String
    
    init(sender: String, receiver: String) {
        self.sender = sender
        self.to = receiver
    }
}

class Mail: Sendable {
    var from: String
    var to: String
    
    init(sender: String, receiver: String) {
        self.from = sender
        self.to = receiver
    }
}

//프로토콜은 특정 인스턴스 메서드나 타입 메서드를 요구할 수도 있다. 구현부인 중괄호 부분을 제외하고 메서드의 이름, 매개변수, 반환 타입들을 작성하며 가변 매개변수도 허용한다.
protocol Receiveable {
    func received(data: Any, from: Sendable2)
}

protocol Sendable2 {
    var from: Sendable2 {get}
    var to: Receiveable? {get}
    
    func send(data: Any)
    
    static func isSendableInstance(_ instance: Any) -> Bool
}

class Message2: Sendable2, Receiveable {
    var from: Sendable2 {
        return self
    }
    
    var to: Receiveable?
    
    func send(data: Any) {
        guard let receiver: Receiveable = self.to else {
            print("Message has no receiver")
            return
        }
        receiver.received(data: data, from: self.from)
    }
    
    func received(data: Any, from: Sendable2) {
        print("Message received \(data) from \(from)")
    }
    
    class func isSendableInstance(_ instance: Any) -> Bool {
        if let sendableInstance: Sendable2 = instance as? Sendable2 {
            return sendableInstance.to != nil
        }
        return false
    }
}

protocol Readable {
    func read()
}

protocol Writeable {
    func write()
}

protocol ReadSpeakable: Readable {
    func speak()
}

protocol ReadWriteSpeakable: Readable, Writeable {
    func speak()
}

class SomeClass_20: ReadWriteSpeakable {
    func read() {}
    func write() {
        
    }
    func speak() {
        
    }
}

protocol ClassOnlyProtocol: class, Readable, Writeable {} //프로토콜의 상속 리스트에 class 키워드를 추가해 클래스 타입에만 채택될 수 있도록 제한할 수 있다.

//프로토콜을 조합하여 요구할 수 있다. 프로토콜을 조합하여 요구할 때는 Protocal & Protocol 과 같이 표현한다.

protocol Named {
    var name: String {get}
}

protocol Aged {
    var age: Int {get}
}

struct Person_20: Named, Aged {
    var name: String
    var age: Int
}

class Car: Named {
    var name: String
    
    init(name: String) {
        self.name = name
    }
}

class Truk: Car, Aged {
    var age: Int
    
    init(name: String, age: Int) {
        self.age = age
        super.init(name: name)
    }
}

func celebrateBirthday(to celebrator: Named & Aged) {
    print("Happy birthday \(celebrator.name)!! Now you are \(celebrator.age)")
}

let yagom_20: Person_20 = Person_20(name: "asdf", age:10)
celebrateBirthday(to: yagom_20)

let myCar: Car = Car(name: "adfa")
//celebrateBirthday(to: myCar)    // 에러 Aged를 충족시키지 못함

//var someVariable: Car & Truck & Aged    //클래스 & 프로토콜 조합에서 클래스 타입은 한 타입만 조합할 수 있다. 에러
var someVariable: Car & Aged
someVariable = Truk(name: "trrr", age: 13)

celebrateBirthday(to: someVariable)

//is 연산자를 통해 해당 인스턴스가 특정 프로토콜을 준수하는 지 확인할 수 있다.
print(yagom_20 is Named)
print(yagom_20 is Aged)

print(myCar is Named)
print(myCar is Aged)


//프로토콜의 요구사항 중 일부를 선택적 요구사항으로 지정할 수 있다.
//선택적 요구사항을 정의하고 싶은 프로토콜은 @objc 속성이 부여된 프로토콜이어야 한다.
//@objc 속성은 해당 프로토콜을 Objective-C 코드에서 사용할 수 있도록 만드는 역할을 한다. Objective-C 코드와 공유하지 않더라도 @objc 속성이 부여되어야 선택적 요구사항을 정의할 수 있다.
//@objc 속성을 사용하려면 Foundation 프레임워크 모듈을 임포트해야 한다.
//선택적 요구사항은 optional 식별자를 요구사항의 정의 앞에 붙여주면 된다.

import Foundation

@objc protocol Moveable {
    func walk()
    @objc optional func fly()
}

class Tiger: NSObject, Moveable {   //@objc 속성의 프로토콜을 사용하기 위해 Objective-C의 클래스인 NSObject를 상속받는다.
    func walk() {
        
    }
}



/**
 익스텐션
 익스텐션은 구조체, 클래스, 열거형, 프로토콜 타입에 새로운 기능을 추가할 수 있다. 기존에 존재하는 기능을 재정의할 수는 없다.
 외부에서 가져온 타입에 내가 원하는 기능을 추가하고자 할 때 익스텐션을 사용한다.
 
 extension 확장할 타입 이름
    // 타입에 추가된 새로운 기능 구현
 
 익스텐션은 기존에 존재하는 타입이 추가로 다른 프로토콜을 채택할 수 있도록 확장할 수도 있다.
 extension 확장할 타입 이름: 프로토콜1, 프로토콜2 {
    //프로토콜 요구사항 구현
 }
 */

extension Int {
    var isEven: Bool {  //연산 프로퍼티
        return self % 2 == 0
    }
}

print(1.isEven)
print(2.isEven)

extension Int {
    func multiply(by n: Int) -> Int {   //메서드
        return self * n
    }
}

print(30.multiply(by: 20))


