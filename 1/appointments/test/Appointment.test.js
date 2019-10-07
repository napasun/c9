import React from 'react';
import ReactDOM from 'react-dom';
import {Appointment} from '../src/Appointment'

describe('AppointmentsDayView', () => {
    let container;

    beforeEach(() => {
        container = document.createElement('div');
    });

    const render = component => ReactDOM.render(component, container);

    it('renders a div with the right id', () => {
        render(<AppointmentsDayView appointments={[]} />);
        //appointmentsDayView 이라는 ID값을 가진 요소가 있는 지 확인한다.
        expect(container.querySelector('div#appointmentsDayView')).not.toBeNull();
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