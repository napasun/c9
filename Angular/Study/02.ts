namespace s2 {
//배열 함수 필터
function positiveNumber(value) {
  return value > 0;
}
var result = [-1,-3,-5,1,2,-10,6,100].filter(positiveNumber);
console.log(result);

// foreach
function printArray(element, index, array) {
  console.log('[' + index + '] = ' + element);
}

[1, 2, ,3,'four'].forEach(printArray);







// 화살표 함수
// 화살표함수 사용하지 않고 함수정의
var pow1 = function (x) { return x * x; };

var pow2 = (x) => { return x * x; };

var pow3 = (x) => { 
    return x * x;    
};

var pow4 = x => x * x;

((x) => {
    console.log(x * x);
})(3);
}