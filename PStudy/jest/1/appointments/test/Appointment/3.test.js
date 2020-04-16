import React from 'react';
import ReactDOM from 'react-dom';
import {Appointment} from "../../src/Appointment";

describe('중복된 로직 beforeEach로 빼기', () => {
    let container;
    let customer;

    beforeEach(() => {
        container = document.createElement('div');
    });
    const render = component => ReactDOM.render(component, container);

    it("문서상에 맞는 문자열이 있는 지 검사한다.", () => {
        customer = { firstName: 'Ashley' };
        render(<Appointment customer={customer} />);
        expect(container.textContent).toMatch('Ashley')
    });

    it('위와 동일하지만 이름만 변경', () => {
        customer = { firstName: 'Jordan' };
        render(<Appointment customer={customer} />);
        expect(container.textContent).toMatch('Jordan');
    });
});
