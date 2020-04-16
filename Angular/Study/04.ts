namespace s4 {


///클래스
// constructor 생성자
// extends 상속
// 상속을 했을 경우 자식은 부모의 생성자를 호출해야 한다.
// 접근자 private, protected, public: 기본

class Car{    
    constructor(public name: string, public numTier: number){}

    protected getName(){
        return this.name;
    }

    getTier(){
        return this.numTier;
    }
}

class SuperCar extends Car{
    constructor(public name: string, public numTier: number){
        super(name,numTier);    // 부모 생성자 호출
    }

    getIncreaseTier(){
        return this.getTier()+10;
    }
}

var mySuperCar = new SuperCar("MySuperCar",5);
console.log(mySuperCar.getTier());
console.log(mySuperCar.getIncreaseTier());









/// 인터페이스
// implements 키워드를 사용해서 클래스에 구현한 인터페이스를 지정한다.
interface SearchFunc {
    (source: string, subString: string): boolean;
}
let mySearch: SearchFunc;
mySearch = function(sour: string, subString: string) {
    let result = sour.search(subString);
    return result > -1;
}










//추상 클래스
abstract class SmallAnimals {
    abstract sound(): string;
    abstract name(): string;
    makeSound(): string {
        return `${this.name()} : ${this.sound()} `;
    }
}

class Mouse extends SmallAnimals{
    sound(): string{
        return "peep peep~";
    }
    name(): string{
        return "mouse";
    }
}

var mouse = new Mouse();
console.log(mouse.makeSound());









}