namespace s451 {
// 타입 스크립트에서의 함수는 매개변수가 일치해야 한다.
function buildName(firstName: string, lastName: string) {
    return firstName + " " + lastName;
}

let result1 = buildName("Bob");                  // error
let result2 = buildName("Bob", "Adams", "Sr.");  // error
let result3 = buildName("Bob", "Adams");


}


namespace s452  {
// '?' 을 사용해서 선택적으로 값을 넣고 안 넣을 수도 있다.
function buildName(firstName: string, lastName?: string) {
    if (lastName)
        return firstName + " " + lastName;
    else
        return firstName;
}

let result1 = buildName("Bob");
let result2 = buildName("Bob", "Adams", "Sr.");  // error
let result3 = buildName("Bob", "Adams");

}


namespace s453 {
// 파라미터 기본값을 지정할 수 있다.
function a(b=2) {
    return b;
}

a();
a(3);

}