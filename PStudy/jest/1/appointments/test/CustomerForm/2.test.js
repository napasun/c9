import React from 'react';
import { createContainer } from '../domManipulators';
import { CustomerForm } from '../../src/CustomerForm';

describe('CustomerForm', () => {
    let render, container;

    beforeEach(() => {
        ({render, container} = createContainer());
    });

    const form = id => container.querySelector(`form[id="${id}"]`);


    it('폼 안에 firstName 이름을 갖는 태그가 Input에 text 타입인지?', () => {
        render(<CustomerForm />);
        const field = form('customer').elements.firstName;
        expect(field).not.toBeNull();
        expect(field.tagName).toEqual('INPUT');
        expect(field.type).toEqual('text');
    });

    it('first name 필드의 값 확인', () => {
        render(<CustomerForm firstName="Ashley" />);
        const field = form('customer').elements.firstName;
        expect(field.value).toEqual('Ashley');
    });

    const firstNameField = () => form('customer').elements.firstName;

    it('first name 필드의 값 확인 위에꺼 리펙토링', () => {
        render(<CustomerForm firstName="Ashley" />);
        expect(firstNameField().value).toEqual('Ashley');
    });

    it('해당 필드에 id가 맞는 지 확인한다.', () => {
        render(<CustomerForm />);
        expect(firstNameField().id).toEqual('firstName');
    });
});
