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
    const firstNameField = () => form('customer').elements.firstName;

    it('서브밋을 하면 설정된 값이 들어온다.', async () => {
        expect.hasAssertions();
        render(
            <CustomerForm
                firstName="Ashley"
                onSubmit={({ firstName }) =>
                    expect(firstName).toEqual('Jamie')
                }
            />
        );
        await ReactTestUtils.Simulate.change( firstNameField(), {
            target: { value: 'Jamie' }
        });
        await ReactTestUtils.Simulate.submit(form('customer'));
    });
});
