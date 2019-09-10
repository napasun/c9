import ReactDOM from 'react-dom';

export const createContainer = () => {
  const container = document.createElement('div');

  return {
    render: component => ReactDOM.render(component, container),
    container
  };
};
// Calling domManipulators creates an empty DOM element, container, and then returns an object with two properties: render and container. We'll see how these can be used in the next section.
// domManipulators를 호출하면 빈 DOM 요소 인 컨테이너가 만들어지고 렌더링 및 컨테이너라는 두 가지 속성이있는 객체가 반환됩니다. 다음 섹션에서 이들을 어떻게 사용할 수 있는지 살펴 보겠습니다.