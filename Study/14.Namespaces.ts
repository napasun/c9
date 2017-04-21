// namespace 키워드를 사용한다.
// 같은 이름의 변수, 함수, 클래스를 오버로드함으로써 혼란스럽게 하는 거를 방지할 수 있다.
// 한파일이 아닌 여러파일로 분할애서 같은 이름의 네임스페이스를 사용할 수 있다.

namespace Validation {
    export interface StringValidator {
        isAcceptable(s: string): boolean;
    }

    const lettersRegexp = /^[A-Za-z]+$/;
    const numberRegexp = /^[0-9]+$/;

    export class LettersOnlyValidator implements StringValidator {
        isAcceptable(s: string) {
            return lettersRegexp.test(s);
        }
    }

    export class ZipCodeValidator implements StringValidator {
        isAcceptable(s: string) {
            return s.length === 5 && numberRegexp.test(s);
        }
    }
}