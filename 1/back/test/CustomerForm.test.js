import React from 'react';
import ReactTestUtils from 'react-dom/test-utils';
import { createContainer } from './domManipulators';
import { CustomerForm } from '../src/CustomerForm';

describe('CustomerForm', () => {
    let render, container;

    const form = id => container.querySelector(`form[id="${id}"]`);
    const field = name => form('customer').elements[name];
    //const firstNameField = () => form('customer').elements.firstName;

    const expectToBeInputFieldOfTypeText = formElement => {
        expect(formElement).not.toBeNull();
        expect(formElement.tagName).toEqual('INPUT');
        expect(formElement.type).toEqual('text');
    };

    beforeEach(() => {
        ({ render, container } = createContainer());
    });

    // it('renders a form', () => {
    //     render(<CustomerForm />);
    //     expect(form('customer')).not.toBeNull();
    // });

    // it('renders the first name field as a text box', () => {
    //     render(<CustomerForm />);
    //     expectToBeInputFieldOfTypeText(firstNameField());
    // });

    // it('includes the existing value for the first name', () => {
    //     render(<CustomerForm firstName="Ashley" />);
    //     expect(firstNameField().value).toEqual('Ashley');
    // });

    // const labelFor = formElement => container.querySelector(`label[for="${formElement}"]`);

    // it('renders a label for the first name field', () => {
    //     render(<CustomerForm />);
    //     expect(labelFor('firstName')).not.toBeNull();
    //     expect(labelFor('firstName').textContent).toEqual('First name');
    // });

    // it('assigns an id that matches the label id to the first name field', () => {
    //     render(<CustomerForm />);
    //     expect(firstNameField().id).toEqual('firstName');
    // });

    // it('renders a label for the first name field', () => {
    //     render(<CustomerForm />);
    //     expect(labelFor('firstName').textContent).toEqual('First name');
    // });

    // it('saves existing first name when submitted', async () => {
    //     expect.hasAssertions();
    //     render(
    //         <CustomerForm
    //           firstName="Ashley"
    //           onSubmit={({ firstName }) =>
    //             expect(firstName).toEqual('Ashley')
    //           }
    //         />
    //     );
    //     await ReactTestUtils.Simulate.submit(form('customer'));
    // });

    // it('saves new first name when submitted', async () => {
    //     expect.hasAssertions();
    //     render(
    //       <CustomerForm
    //         firstName="Ashley"
    //         onSubmit={({ firstName }) =>
    //           expect(firstName).toEqual('Jamie')
    //         }
    //       />
    //     );
    //     await ReactTestUtils.Simulate.change( firstNameField(), {
    //       target: { value: 'Jamie' }
    //     });
    //     await ReactTestUtils.Simulate.submit(form('customer'));
    //   });

    it('has a submit button', () => {
        render(<CustomerForm />);
        const submitButton = container.querySelector(
          'input[type="submit"]'
        );
        expect(submitButton).not.toBeNull();
    });

    /***
     * 
     * 
     */
    const itRendersAsATextBox = (fieldName) =>
    it('renders as a text box', () => {
        render(<CustomerForm />);
        expectToBeInputFieldOfTypeText(field(fieldName));
    });
    
    itRendersAsATextBox('firstName');

    const itIncludesTheExistingValue = (fieldName) =>
    it('includes the existing value', () => {
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
            target: { value: 'firstName', name: fieldName }
        });
        await ReactTestUtils.Simulate.submit(form('customer'));
    });

    itSubmitsNewValue('firstName', 'firstName');


    // const itRendersALabel = (fieldName, text) =>
    // it('renders a label', () => {
    //     renderWithStore(<CustomerForm {...validCustomer} />);
    //     expect(labelFor(fieldName)).not.toBeNull();
    //     expect(labelFor(fieldName).textContent).toEqual(text);
    // });

    // const itAssignsAnIdThatMatchesTheLabelId = fieldName =>
    // it('assigns an id that matches the label id', () => {
    //     renderWithStore(<CustomerForm {...validCustomer} />);
    //     expect(field('customer', fieldName).id).toEqual(fieldName);
    // });

    // const itSubmitsExistingValue = (fieldName, value) =>
    // it('saves existing value when submitted', async () => {
    //     renderWithStore(
    //         <CustomerForm
    //         {...validCustomer}
    //         {...{ [fieldName]: value }}
    //         />
    //     );

    //     await submit(form('customer'));

    //     expect(requestBodyOf(window.fetch)).toMatchObject({
    //         [fieldName]: value
    //     });
    // });


    describe('first name field', () => {
        itRendersAsATextBox('firstName');
        itIncludesTheExistingValue('firstName');
        // itRendersALabel('firstName', 'First name');
        // itAssignsAnIdThatMatchesTheLabelId('firstName');
        // itSubmitsExistingValue('firstName', 'firstName');
        //itSubmitsNewValue('firstName', 'newValue');
    });

    describe('last name field', () => {
        itRendersAsATextBox('lastName');
    });
});

