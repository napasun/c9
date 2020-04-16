import React from 'react';
import { createContainer } from "../domManipulators";
import { CustomerForm } from "../../src/CustomerForm";
import ReactTestUtils from 'react-dom/test-utils';

describe('CustomerForm', () => {
    let render, container;

    beforeEach(() => {
        ({ render, container } = createContainer());
    });

    const form = (id) => container.querySelector(`form[id="${id}"]`);
    const expectToBeInputFieldOfTypeText = formElement => {
        expect(formElement).not.toBeNull();
        expect(formElement.tagName).toEqual('INPUT');
        expect(formElement.type).toEqual('text');
    };
    const field = name => form('customer').elements[name];

    const itRendersAsATextBox = () =>
        it('텍스트 박스 검증', () => {
            render(<CustomerForm />);
            expectToBeInputFieldOfTypeText(field('firstName'));
        });

    itRendersAsATextBox();

    const itIncludesTheExistingValue = (fieldName) =>
        it('값 검증', () => {
            render(<CustomerForm { ...{[fieldName]: 'value'} } />);
            expect(field(fieldName).value).toEqual('value');
        });

    itIncludesTheExistingValue('firstName');

    const itSubmitsNewValue = (fieldName, value) =>
        it('서브밋 테스트', async () => {
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

    const handleChangeFirstName = ({ target }) =>
        setCustomer(customer => ({
            ...customer,
            firstName: target.value
        }));

    const handleChangeLastName = ({ target }) =>
        setCustomer(customer => ({
            ...customer,
            lastName: target.value
        }));

    const handleChangePhoneNumber = ({ target }) =>
        setCustomer(customer => ({
            ...customer,
            phoneNumber: target.value
        }));

    const handleChange = ({ target }) =>
        setCustomer(customer => ({
            ...customer,
            [target.name]: target.value
        }));

    it('has a submit button', () => {
        render(<CustomerForm />);
        const submitButton = container.querySelector(
            'input[type="submit"]'
        );
        expect(submitButton).not.toBeNull();
    });
});
