import React from 'react';
import ReactDOM from 'react-dom';
import {Appointment} from "../../src/Appointment";

describe('중복된 거 지우기 리펙토링', () => {
    it("문서상에 맞는 문자열이 있는 지 검사한다.", () => {
        const customer = { firstName: 'Ashley' };
        const container = document.createElement('div');    //이 태그 안에 렌더
        ReactDOM.render(<Appointment customer={customer} />, container);
        expect(container.textContent).toMatch('Ashley')
    });

    it('위와 동일하지만 이름만 변경', () => {
        const customer = { firstName: 'Jordan' };
        const container = document.createElement('div');
        ReactDOM.render(<Appointment customer={customer} />, container);
        expect(container.textContent).toMatch('Jordan');
    });
});
