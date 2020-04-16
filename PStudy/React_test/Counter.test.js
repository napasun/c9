import React from 'react';
import { render, fireEvent } from 'react-testing-library';
import Counter from './Counter';
//fireEvent.이벤트이름(DOM, 이벤트객체);
//fireEvent.change(myInput, { target: { value: 'hello world' } });


describe('<Counter />', () => {
  it('matches snapshot', () => {
    const utils = render(<Counter />);
    expect(utils.container).toMatchSnapshot();
  });
  it('has a number and two buttons', () => {
    const utils = render(<Counter />);
    // 버튼과 숫자가 있는지 확인
    utils.getByText('0');
    utils.getByText('+1');
    utils.getByText('-1');
  });
  it('increases', () => {
    const utils = render(<Counter />);
    const number = utils.getByText('0');
    const plusButton = utils.getByText('+1');
    // 클릭 이벤트를 두번 발생시키기
    fireEvent.click(plusButton);
    fireEvent.click(plusButton);
    expect(number).toHaveTextContent('2'); // jest-dom 의 확장 matcher 사용
    expect(number.textContent).toBe('2'); // textContent 를 직접 비교
  });
  it('decreases', () => {
    const utils = render(<Counter />);
    const number = utils.getByText('0');
    const plusButton = utils.getByText('-1');
    // 클릭 이벤트를 두번 발생시키기
    fireEvent.click(plusButton);    //  여기서 fireEvent() 라는 함수를 불러와서 사용했는데요, 이 함수는 이벤트를 발생시켜줍니다.
    fireEvent.click(plusButton);
    expect(number).toHaveTextContent('-2'); // jest-dom 의 확장 matcher 사용
  });
});