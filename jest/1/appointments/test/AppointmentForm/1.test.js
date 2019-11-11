import React from 'react';
import { createContainer } from '../domManipulators';
import { AppointmentForm } from '../../src/AppointmentForm';
/**
 * select
 * */
describe('AppointmentForm', () => {
    let render, container;

    beforeEach(() => {
        ({ render, container } = createContainer());
    });

    const form = id => container.querySelector(`form[id="${id}"]`);

    it('renders a form', () => {
        render(<AppointmentForm />);
        expect(form('appointment')).not.toBeNull();
    });

    describe('service field', () => {
        it('select box가 있는 지 확인한다.', () => {
            render(<AppointmentForm />);
            expect(form('appointment').elements.service).not.toBeNull();
            expect(form('appointment').elements.service.tagName).toEqual('SELECT');
        });
        const form = id => container.querySelector(`form[id="${id}"]`);

        const field = name => form('appointment').elements[name];

        it('select box가 있는 지 확인한다. 위와 동일', () => {
            render(<AppointmentForm />);
            expect(field("service")).not.toBeNull();
            expect(field("service").tagName).toEqual('SELECT');
        });

        it('select 박스에 요소를 검사한다.', () => {
            const selectableServices = [
                'Cut',
                'Blow-dry',
                'Cut & color',
                'Beard trim',
                'Cut & beard trim',
                'Extensions' ];

            render(<AppointmentForm selectableServices={selectableServices}/>);

            const optionNodes = Array.from(
                field('service').childNodes
            );
            const renderedServices = optionNodes.map(
                node => node.textContent
            );
            expect(renderedServices).toEqual(expect.arrayContaining(selectableServices));
        });

        const findOption = (dropdownNode, textContent) => {
            const options = Array.from(dropdownNode.childNodes);
            return options.find(option => option.textContent === textContent);
        };

        it('설정된 기본값이 설정되어 있는 가?', () => {
           const services = ['Cut', 'Blow-dry'];
            render(
                <AppointmentForm
                    selectableServices={services}
                    service="Blow-dry"
                />
            );
            const option = findOption(field('service'), 'Blow-dry');
            expect(option.selected).toBeTruthy();
        });
    });
});
