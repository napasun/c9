import React from 'react';
import { createContainer } from '../domManipulators';
import { CustomerForm } from "../../src/CustomerForm";
import ReactTestUtils from 'react-dom/test-utils';

/**
 * 테스트 더블, 스파이를 사용해서 제출
 * */
describe('', () => {
    let render, container;

    beforeEach(() => {
        ({ render, container } = createContainer());
    });

    const form = id => container.querySelector(`form[id="${id}"]`);

    it('submit 확인', async () => {
        expect.hasAssertions();

        render(
            <CustomerForm
                firstName="Ashley"
                onSubmit={customer => expect(customer.firstName).toEqual('Ashley')
                }
            />
        );

        ReactTestUtils.Simulate.submit(form('customer'));
    });

    const itSubmitsExistingValue = fieldName =>
    it('saves existing value when submitted', async () => {
        //위와 동일 Arrange-Act-Assert, ugly expect.hasAssertions() call 제
        let submitArg;

        render(<CustomerForm
            { ...{[fieldName]: 'value'} }
            onSubmit={customer => submitArg = customer}
        />);
        ReactTestUtils.Simulate.submit(form('customer'));
        expect(submitArg).toBeDefined();    // 변수가 정의되지 않았는 지 확인
        expect(submitArg[fieldName]).toEqual('value');
    });

    const singleArgumentSpy = () => {
        let receivedArgument;
        return {
            fn: arg => (receivedArgument = arg),
            receivedArgument: () => receivedArgument
        };
    };

    const itSubmitsExistingValue2 = fieldName =>
        it('saves existing value when submitted', async () => {
            const submitSpy = singleArgumentSpy();

            render(
                <CustomerForm
                    {...{ [fieldName]: 'value' }}
                    onSubmit={submitSpy.fn}
                />
            );
            ReactTestUtils.Simulate.submit(form('customer'));

            expect(submitSpy.receivedArgument()).toBeDefined();
            expect(submitSpy.receivedArgument()[fieldName]).toEqual('value');
        });

    const spy = () => {
        let receivedArguments;
        return {
            fn: (...args) => (receivedArguments = args),
            receivedArguments: () => receivedArguments,
            receivedArgument: n => receivedArguments[n]
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

    const itSubmitsExistingValue3 = fieldName =>
        it('saves existing value when submitted', async () => {
            const submitSpy = spy();

            render(
                <CustomerForm
                    {...{ [fieldName]: 'value' }}
                    onSubmit={submitSpy.fn}
                />
            );
            ReactTestUtils.Simulate.submit(form('customer'));

            expect(submitSpy.receivedArguments()).toBeDefined();
            expect(submitSpy).toHaveBeenCalled();   //모의함수가 호출되었는 지 확인한다.
            expect(submitSpy.receivedArgument(0)[fieldName]).toEqual('value');
        });
});
