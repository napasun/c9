import React from 'react';
import { createContainer } from "../domManipulators";
import { CustomerForm } from "../../src/CustomerForm";

describe('CustomerForm', () => {
    let render, container;

    beforeEach(() => {
        ({ render, container } = createContainer());
    });

    const form = id => container.querySelector(`form[id="${id}"]`);

    it('form 태그가 있는 지 확인', () => {
        render(<CustomerForm />);
        expect(container.querySelector('form[id="customer"]')).not.toBeNull();
    });

    it('form 태그가 찾는 거를 따로 뺌', () => {
        render(<CustomerForm />);
        expect(form('customer')).not.toBeNull();
    });
});
