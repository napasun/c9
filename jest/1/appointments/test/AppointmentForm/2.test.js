import React from 'react';
import { createContainer } from '../domManipulators';
import { AppointmentForm } from '../../src/AppointmentForm';
import ReactTestUtils from 'react-dom/test-utils';
/**
 * radio
 * */
describe('AppointmentForm', () => {
    let render, container;

    beforeEach(() => {
        ({ render, container } = createContainer());
    });

    const form = id => container.querySelector(`form[id="${id}"]`);

    describe('달력 테스트', () => {
        const timeSlotTable = () => container.querySelector('table#time-slots');

        it('테이블에 time slots이 렌더링 되었는 가?', () => {
            render(<AppointmentForm />);
            expect(container.querySelector('table#time-slots')).not.toBeNull();
        });

        it('시작시간, 종료시간 설정 30분단위로 목록을 만들어내는 가?', () => {
            render(<AppointmentForm salonOpensAt={9} salonClosesAt={11} />);
            const timesOfDay = timeSlotTable().querySelectorAll(
                'tbody >* th'
            );
            expect(timesOfDay).toHaveLength(4);
            expect(timesOfDay[0].textContent).toEqual('09:00');
            expect(timesOfDay[1].textContent).toEqual('09:30');
            expect(timesOfDay[3].textContent).toEqual('10:30');
        });

        it('해당하는 태그가 있는 지 검사한다.', () => {
            render(<AppointmentForm />);
            const headerRow = timeSlotTable().querySelector(
                'thead > tr'
            );
            expect(headerRow.firstChild.textContent).toEqual('');
        });

        it('설정된 날로부터 7일을 나열 한다.', () => {
            const today = new Date(2018, 11, 1);
            render(<AppointmentForm today={today} />);
            const dates = timeSlotTable().querySelectorAll(
                'thead >* th:not(:first-child)'
            );
            expect(dates).toHaveLength(7);
            expect(dates[0].textContent).toEqual('Sat 01');
            expect(dates[1].textContent).toEqual('Sun 02');
            expect(dates[6].textContent).toEqual('Fri 07');
        });

        it('라디오 버튼이 있는 가?', () => {
            const today = new Date();
            const availableTimeSlots = [
                {startsAt: today.setHours(9, 0, 0, 0)},
                {startsAt: today.setHours(9, 30, 0, 0)}
            ];
            render(
                <AppointmentForm
                    availableTimeSlots={availableTimeSlots}
                    today={today}
                />
            );
            const cells = timeSlotTable().querySelectorAll('td');
            expect(cells[0].querySelector('input[type="radio"]')).not.toBeNull();
            expect(cells[7].querySelector('input[type="radio"]')).not.toBeNull();
        });

        it('does not render radio buttons for unavailable time slots', () => {
            render(<AppointmentForm availableTimeSlots={[]} />);
            const timesOfDay = timeSlotTable().querySelectorAll(
                'input'
            );
            expect(timesOfDay).toHaveLength(0);
        });

        const startsAtField = index => container.querySelectorAll(`input[name="startsAt"]`)[index];

        it('sets radio button values to the index of the corresponding appointment', () => {
            const today = new Date();
            const availableTimeSlots = [
                { startsAt: today.setHours(9, 0, 0, 0) },
                { startsAt: today.setHours(9, 30, 0, 0) }
            ];
            render(
                <AppointmentForm
                    availableTimeSlots={availableTimeSlots}
                    today={today}
                />);
            expect(startsAtField(0).value).toEqual(availableTimeSlots[0].startsAt.toString());
            expect(startsAtField(1).value).toEqual(availableTimeSlots[1].startsAt.toString());
        });

        it.skip('saves new value when submitted', () => {
            expect.hasAssertions();
            const today = new Date();
            const availableTimeSlots = [
                { startsAt: today.setHours(9, 0, 0, 0) },
                { startsAt: today.setHours(9, 30, 0, 0) }
            ];
            render(
                <AppointmentForm
                    availableTimeSlots={availableTimeSlots}
                    today={today}
                    startsAt={availableTimeSlots[0].startsAt}
                    onSubmit={({ startsAt }) =>
                        expect(startsAt).toEqual(availableTimeSlots[1].startsAt)
                    }
                />
            );
            ReactTestUtils.Simulate.change(startsAtField(1), {
                target: {
                    value: availableTimeSlots[1].startsAt.toString(),
                    name: 'startsAt'
                }
            });
            ReactTestUtils.Simulate.submit(form('appointment'));
        });
    });
});
