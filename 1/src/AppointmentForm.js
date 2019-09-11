import React from 'react';

export const AppointmentForm = ({ selectableServices }) => (
    <form id="appointment">
        <select name="service" value={service} readOnly>
            <option />
            {selectableServices.map(s => (
                <option key={s}>{s}</option>
            ))}
            </select>
    </form>
);

AppointmentForm.defaultProps = {    //테스트 안함 정적 데이터가 아닌 동작을 테스트
    selectableServices: [
      'Cut',
      'Blow-dry',
      'Cut & color',
      'Beard trim',
      'Cut & beard trim',
      'Extensions']
  };