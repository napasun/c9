///printLabel 함수의 매개변수 labelledObj 객체에 label 이라는 문자열 속성이 있는 지 검사한다.
function printLabel(labelledObj: { label: string }) {
    console.log(labelledObj.label);
}
let myObj = {size: 10, label: "Size 10 Object"};
//let myObj = {size: 10, label2: "Size 10 Object"}; //속성 불일치
//let myObj = {size: 10, label: 3};    //타입 불일치
printLabel(myObj);

///