import React from 'react';
import { createContainer } from "../domManipulators";
import { CustomerForm } from "../../src/CustomerForm";

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
    const firstNameField = () => form('customer').elements.firstName;

    const labelFor = formElement =>
        container.querySelector(`label[for="${formElement}"]`);

    it('레이블 필드 검증', () => {
        render(<CustomerForm />);
        expect(labelFor('firstName')).not.toBeNull();
        expect(labelFor('firstName').textContent).toEqual('First name');
    });

    it('id 값이 맞는 지 확인한다.', () => {
        render(<CustomerForm />);
        expect(firstNameField().id).toEqual('firstName');
    });
});
