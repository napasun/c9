import React from 'react';
import { createContainer } from '../domManipulators';
import { CustomerForm } from "../../src/CustomerForm";
import ReactTestUtils from 'react-dom/test-utils';

/**
 * 테스트 더블, 스파이를 사용해서 제출
 * */


describe('', () => {
    const originalFetch = window.fetch;
    let fetchSpy;
    let render, container;
    let returnValue;

    beforeEach(() => {
        ({ render, container } = createContainer());
        fetchSpy = spy();
        window.fetch = fetchSpy.fn;
    });

    afterEach(() => {
        window.fetch = originalFetch;
    });

    const form = id => container.querySelector(`form[id="${id}"]`);
    const field = name => form('customer').elements[name];

    const spy = () => {
        let receivedArguments;
        return {
            fn: (...args) => {
                receivedArguments = args;
                return returnValue;
            },
            receivedArguments: () => receivedArguments,
            receivedArgument: n => receivedArguments[n],
            stubReturnValue: value => returnValue = value
        };
    };

    expect.extend({
        toHaveBeenCalled(received) {
            if (received.receivedArguments() === undefined) {
                return {
                    pass: false,
                    message: () => 'Spy was not called.'
                };
            }
            return { pass: true, message: () => 'Spy was called.' };
        }
    });

    const itSubmitsExistingValue = fieldName =>
        it('saves existing value when submitted', async () => {
            const fetchSpy = spy();

            render(
                <CustomerForm
                    {...{ [fieldName]: 'value' }}
                    fetch={fetchSpy.fn}
                    onSubmit={() => {}}
                />
            );
            ReactTestUtils.Simulate.change(field(fieldName), {
                target: { value: 'newValue', name: fieldName }
            });
            ReactTestUtils.Simulate.submit(form('customer'));

            const fetchOpts = fetchSpy.receivedArgument(1);
            expect(JSON.parse(fetchOpts.body)[fieldName]).toEqual('value');
        });

    it('calls fetch with the right properties when submitting data', async () => {
        const fetchSpy = spy();
        render(
            <CustomerForm fetch={fetchSpy.fn} onSubmit={() => {}} />
        );
        ReactTestUtils.Simulate.submit(form('customer'));
        expect(fetchSpy).toHaveBeenCalled();
        expect(fetchSpy.receivedArgument(0)).toEqual('/customers');

        const fetchOpts = fetchSpy.receivedArgument(1);
        expect(fetchOpts.method).toEqual('POST');
        expect(fetchOpts.credentials).toEqual('same-origin');
        expect(fetchOpts.headers).toEqual({'Content-Type': 'application/json'});
    });

});
