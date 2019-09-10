### describe

테스트 스위트를 정의

### it

it함수는 단일 테스트를 정의


### 테스트에서 렌더링 반응

이 시험에 합격하려면 몇 가지 를 작성해야합니다 프로덕션 코드를 호출 할 예상 이상의 코드

React 컴포넌트가 렌더링 될 때 어떤 일이 발생하는지 테스트 중이므로 ReactDOM.render함수 를 호출해야 합니다. 이 함수는 component(이 경우에는이라고 함 Appointment)를 가져 와서 React render매직을 수행하고 기존 DOM 노드를 새로 렌더링 된 노드 트리로 바꿉니다. 대체하는 DOM 노드를 React라고 container합니다.

메소드 서명 은 다음과 같습니다 .

ReactDOM.render(component, container)


## Error

### ReferenceError: document is not defined

* --env=jsdom

```
"test": "./node_modules/.bin/jest --env=jsdom"
```


"더 많은 서둘러; 더 느린 속도"규칙은 다른 많은 삶의 영역과 마찬가지로 코딩에도 적용됩니다. 리팩토링 단계를 건너 뛰면 코드 품질이 저하됩니다. 리팩토링을 건너 뛰는 습관이 생길 경우 곧 코드 기반을 다루기가 어려워 질 것입니다.

일관되게 리팩터링하려면 많은 개인 훈련이 필요하지만 코드 의 보상을 얻을 수 있습니다 나이가 들어도 유지 관리가 가능한베이스.


### beforeEach

두 테스트는 모두 설정 또는 배열로 시작합니다. 그 설정 때모든 테스트에 공통적이며 beforeEach대신 블록 으로 승격 할 수 있습니다 . 이 블록의 코드는 각 테스트 전에 실행됩니다.


## TDD 의 단계 주기는 다음과 같습니다.

실패한 테스트 작성 : 원하는 기능을 설명하는 간단한 테스트를 작성하십시오. 테스트를 실행하고 실패했는지 확인하십시오. 실패하지 않으면 좋은 테스트가 아닙니다. 돌아가서 다시 시도하십시오.
통과 시키 십시오 : 테스트를 녹색으로 만드십시오. 할 일 간단한을작동하는 것. 엉망으로 만드십시오. 나중에 정리할 수 있습니다.
코드 리팩토링 : 중지, 속도 저하 및 저항다음 기능으로 넘어 가려는 충동. 프로덕션 코드와 테스트 코드를 모두 깔끔하게 만들기 위해 열심히 노력하십시오.


## ReactTestUtils.Simulate.click

반응 구성 요소는 합성 이벤트 라고하는 것에 응답 합니다. React는이를 사용하여 DOM 이벤트 모델에서 브라우저 불일치를 마스킹합니다. 이는 JSDOM을 통해 발생하는 표준 이벤트를 발생시킬 수 없음을 의미합니다. 대신, ReactTestUtils.Simulate객체를 사용하여 이벤트를 발생시킵니다.


## container.textContent

container.textContent는 이 텍스트가 어딘가에 나타나기를 원하지만 어디에서든 상관하지 않는다고 말하는 것과 같습니다 . 

## 추가 학습

* Node.js: https://nodejs.org/en/
* Correctly configuring the Babel env preset: https://babeljs.io/docs/en/babel-preset-env
* Jest documentation on the watch tool: https://jestjs.io/docs/en/cli#watch
* Hooks at a Glance: https://ko.reactjs.org/docs/hooks-intro.html


### React hook 수명주기

당신이 클래스 수명주기 방법 반응에 익숙하다면, 당신은 생각할 수 useEffect로 후크 componentDidMount, componentDidUpdate및 componentWillUnmount결합.


## anync

async키워드는 우리의 테스트 함수 정의하기 전에, 첫 번째 줄에 나타납니다. 이것은 Jest에게 테스트가 약속을 반환하고 테스트 실행자가 테스트의 성공 또는 실패를보고하기 전에 약속이 해결 될 때까지 기다려야한다는 것을 알려줍니다.

## hasAssertions

hasAssertions기대는 적어도 하나의 주장이 발생할 것으로 예상한다고 농담을 알려줍니다. 이 줄이 없으면 작업 대기열이 지워지지 만 이벤트 처리기가 실행되지 않은 경우 Jest는 테스트를 행복하게 통과 할 수 있습니다. 테스트가 완료되면 어떻게되는지 살펴 보겠습니다.
The hasAssertions expectation tells Jest that it should expect at least one assertion to occur. Without this line, Jest could happily pass your test if the task queue clears but your event handler was never executed. We'll see how this might occur once the test is completed.


## npx jest --verbose

결과 상세보기