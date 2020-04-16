//ECMAScript 2015 부터 모듈이 생김
// export 키워드를 사용해서 선언한다.
// import 키워드로 내보낸 모듈을 가져온다.
export interface StringValidator {
    isAcceptable(s: string): boolean;
}