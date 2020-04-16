import React from 'react';
import ReactDOM from 'react-dom';
import {Appointment} from "../../src/Appointment";

describe('테스트 스위프트 정의', () => {
    it('단일 테스트 정의', () => {
    });

    it("문서상에 맞는 문자열이 있는 지 검사한다.", () => {
        const customer = { firstName: 'Ashley' };
        const component = <Appointment customer={customer} />;
        const container = document.createElement('div');    //이 태그 안에 렌더
        ReactDOM.render(component, container);
        expect(container.textContent).toMatch('Ashley')
    });

    it('위와 동일하지만 이름만 변경', () => {
        const customer = { firstName: 'Jordan' };
        const component = <Appointment customer={customer} />;
        const container = document.createElement('div');
        ReactDOM.render(component, container);
        expect(container.textContent).toMatch('Jordan');
    });

    it.skip("넘어가기", () => {})
});
