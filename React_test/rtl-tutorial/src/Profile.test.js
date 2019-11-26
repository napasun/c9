import React from 'react';
import { render } from "@testing-library/react";
import Profile from './Profile';

describe('<Profile>', () => {
    it('matches snapshot', () => {
        const utils = render(<Profile username="velopert" name="test" />);
        expect(utils.container).toMatchSnapshot();
    });

    it('shows the props correctly', () => {
        const utils = render(<Profile username="velopert" name="test" />);
        utils.getByText('velopert'); // velopert 라는 텍스트를 가진 엘리먼트가 있는지 확인
        utils.getByText('(test)'); // (김민준) 이라는 텍스트를 가진 엘리먼트가 있는지 확인
        utils.getByText(/te/); // 정규식 /김/ 을 통과하는 엘리먼트가 있는지 확인
    })
});