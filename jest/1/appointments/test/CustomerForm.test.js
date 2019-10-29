import React from 'react';
import { createContainer } from './domManipulators';
import { CustomerForm } from '../src/CustomerForm';

import ReactTestUtils from 'react-dom/test-utils';


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

    it('renders a label for the first name 필드 값 확인', () => {
        render(<CustomerForm />);
        expect(labelFor('firstName')).not.toBeNull();
        expect(labelFor('firstName').textContent).toEqual('First name');
    });



    // ReactTestUtils
    it('saves existing first name when submitted', async () => {    //anync 테스트의 성공 또는 실패를 보고하기 전까지 기다려라.
        expect.hasAssertions(); // 적어도 하나의 주장이 발생한다.
        render(
            <CustomerForm
                firstName="Ashley"
                onSubmit={({ firstName }) =>
                    expect(firstName).toEqual('Ashley') // hasAssertions 가 없으면 테스트를 통과한다.
                }
            />
        );

        await ReactTestUtils.Simulate.submit(form('customer'));
    });
});
//
describe('first name field', () => {
    let render, container;

    beforeEach(() => {
        ({ render, container } = createContainer());
    });
    const form = id => container.querySelector(`form[id="${id}"]`);

    const field = name => form('customer').elements[name];

    const expectToBeInputFieldOfTypeText = formElement => {
        expect(formElement).not.toBeNull();
        expect(formElement.tagName).toEqual('INPUT');
        expect(formElement.type).toEqual('text');
    };

    const itRendersAsATextBox = (fieldName) =>

        it('텍스트 박스를 렌더링 했는 지 확인', () => {
            render(<CustomerForm />);
            expectToBeInputFieldOfTypeText(field(fieldName));
        });
    //
    itRendersAsATextBox("firstName");

    const itIncludesTheExistingValue = (fieldName) =>
        it('값 설정 확인', () => {
            render(<CustomerForm { ...{[fieldName]: 'value'} } />);
            expect(field(fieldName).value).toEqual('value');
        });

    itIncludesTheExistingValue('firstName');

    const itSubmitsNewValue = (fieldName, value) =>
        it('saves new value when submitted', async () => {
            expect.hasAssertions();
            render(
                <CustomerForm
                    { ...{[fieldName]: 'existingValue'} }
                    onSubmit={props =>
                        expect(props[fieldName]).toEqual(value)
                    }
                />);
            await ReactTestUtils.Simulate.change(field(fieldName), {
                target: { value }
            });
            await ReactTestUtils.Simulate.submit(form('customer'));
        });

    itSubmitsNewValue('firstName', 'firstName');


    describe('first name field', () => {
        itRendersAsATextBox('firstName');
        itIncludesTheExistingValue('firstName');
        // itRendersALabel('firstName', 'First name');
        // itAssignsAnIdThatMatchesTheLabelId('firstName');
        // itSubmitsExistingValue('firstName', 'firstName');
        itSubmitsNewValue('firstName', 'anotherFirstName');
    });

    describe('last name field', () => {
        itRendersAsATextBox('lastName');
    });

    it('has a submit button', () => {
        render(<CustomerForm />);
        const submitButton = container.querySelector(
            'input[type="submit"]'
        );
        expect(submitButton).not.toBeNull();
    });
});
