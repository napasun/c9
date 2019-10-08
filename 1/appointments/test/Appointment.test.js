import React from 'react';
import ReactDOM from 'react-dom';
import {Appointment, AppointmentsDayView} from '../src/Appointment'
import ReactTestUtils from 'react-dom/test-utils';

describe('AppointmentsDayView', () => {
    let container;

    beforeEach(() => {
        container = document.createElement('div');
    });

    const render = component => ReactDOM.render(component, container);

    it('div에 해당하는 ID를 가진 요소가 있는 지 확', () => {
        render(<AppointmentsDayView appointments={[]} />);
        //appointmentsDayView 이라는 ID값을 가진 요소가 있는 지 확인한다.
        expect(container.querySelector('div#appointmentsDayView')).not.toBeNull();
    });

    const today = new Date();
    const appointments = [
        {
            startsAt: today.setHours(12, 0),
            customer: { firstName: 'Ashley' }
        },
        {
            startsAt: today.setHours(13, 0),
            customer: { firstName: 'Jordan' }
        }
    ];

    it('renders multiple appointments in an ol element', () => {
        render(<AppointmentsDayView appointments={appointments} />);
        expect(container.querySelector('ol')).not.toBeNull();   //ol 요소가 있는 지?
        // ol 요소 자식으로 2개가 있는 지
        expect(container.querySelector('ol').children).toHaveLength(2);
        expect(container.querySelectorAll('li')[0].textContent).toEqual('12:00');
        expect(container.querySelectorAll('li')[1].textContent).toEqual('13:00');
    });

    it('값이 없을 경우, 나와야 되는 메시지', () => {
        render(<AppointmentsDayView appointments={[]} />);
        expect(container.textContent).toMatch('There are no appointments scheduled for today.');
    });

    it('selects the first appointment by default', () => {
        render(<AppointmentsDayView appointments={appointments} />);
        expect(container.textContent).toMatch('Ashley');
    });

    it('li 요소 안에 button이 있다.', () => {
        render(<AppointmentsDayView appointments={appointments} />);
        expect(container.querySelectorAll('li > button')).toHaveLength(2);
        expect(container.querySelectorAll('li > button')[0].type).toEqual('button');
    });

    it.skip('선택된 텍스트가 나오는 지 확인', () => {
        render(<AppointmentsDayView appointments={appointments} />);
        const button = container.querySelectorAll('button')[1];
        ReactTestUtils.Simulate.click(button);
        expect(container.textContent).toMatch('Jordan');
    });
});


describe('Appointment', () => {
    let container;
    let customer;

    beforeEach(() => {
        container = document.createElement('div');
    });

    const render = component => ReactDOM.render(component, container);

    it('first name 렌더링 확인, 리펙토링', () => {
        const customer = { firstName: 'Ashley' };
        render(<Appointment customer={customer} />);
        expect(container.textContent).toMatch('Ashley');
    });

    it('first name 렌더링 확인, 인라인으로 렌더링', () => {
        const customer = { firstName: 'Ashley' };
        const container = document.createElement('div');
        ReactDOM.render(<Appointment customer={customer} />, container);
        expect(container.textContent).toMatch('Ashley');
    });

    it('first name 렌더링 확인', () => {
        const customer = { firstName: 'Ashley' };
        const component = <Appointment customer={customer} />;
        const container = document.createElement('div');    //div 태그를 만든다.
        document.body.appendChild(container);       //div 태그를 body에 넣는 다.
        //ReactDOM.render(component, container) component를 가져와서 render를 수행하고
        //기존 DOM노드를 새로 렌더링 된 노드트리로 바꾼다. 대체되는 DOM노드를 container에서 가져온다.
        ReactDOM.render(component, container);

        expect(document.body.textContent).toMatch('Ashley');
    });

    it.skip('renders another customer first name', () => {
        const customer = { firstName: 'Jordan' };
        const component = <Appointment customer={customer} />;
        const container = document.createElement('div');
        document.body.appendChild(container);

        ReactDOM.render(component, container);

        expect(document.body.textContent).toMatch('Jordan');
    });
});
