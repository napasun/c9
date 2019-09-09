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
