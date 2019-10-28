import React from 'react';
import { createContainer } from './domManipulators';
import { CustomerForm } from '../src/CustomerForm';

describe('CustomerForm', () => {
    let render, container;

    beforeEach(() => {
        ({ render, container } = createContainer());
    });
    const form = id => container.querySelector(`form[id="${id}"]`);

    it('해당하는 폼이 있는 지 확인', () => {
        render(<CustomerForm />);
        expect(
            container.querySelector('form[id="customer"]')
        ).not.toBeNull();

        expect(form('customer')).not.toBeNull();
    });



    it('firstName 엘리먼트 태그가이 input 이고 text 타입인지', () => {
        render(<CustomerForm />);
        const field = form('customer').elements.firstName;
        expect(field).not.toBeNull();
        expect(field.tagName).toEqual('INPUT');
        expect(field.type).toEqual('text');
    });
    const expectToBeInputFieldOfTypeText = formElement => {
        expect(formElement).not.toBeNull();
        expect(formElement.tagName).toEqual('INPUT');
        expect(formElement.type).toEqual('text');
    };
    it('위에 테스트와 동일 가독성을 높인 테스트', () => { // 가독성은 계산을 최소화 하는 것보다 중
        render(<CustomerForm />);
        expectToBeInputFieldOfTypeText(firstNameField());
    });



    it('firstName의 값이 Ashley인지 확인한다.', () => {
        render(<CustomerForm firstName="Ashley" />);
        const field = form('customer').elements.firstName;
        expect(field.value).toEqual('Ashley');
    });

    const firstNameField = () => form('customer').elements.firstName;
    it('firstName의 값이 Ashley인지 확인한다.', () => {
        render(<CustomerForm firstName="Ashley" />);
        expect(firstNameField().value).toEqual('Ashley');
    });



    const labelFor = formElement =>
        container.querySelector(`label[for="${formElement}"]`);

    it('renders a label for the first name field', () => {
        render(<CustomerForm />);
        expect(labelFor('firstName')).not.toBeNull();
        expect(labelFor('firstName').textContent).toEqual('First name');
    });
});
