function s3() {
// getter, setter
// get, set 키워드를 사용해서 만든다.
// 게터 함수와 세터 함수를 정의하는 형태가 함수가 아닌 속성처럼 사용된다.
class Hello{    
    private _hello: string;
    
    get hello(): string{
        return this._hello+" world";
    }

    set hello(name: string){
        this._hello = name;
    }
}

var m = new Hello();

//함수호출이 아닌 속성처럼 사용
m.hello = "hello";  
console.log(m.hello);
//

}