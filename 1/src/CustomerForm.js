import React, { useState } from 'react';

export const CustomerForm = ({ firstName, onSubmit }) => {
    const [ customer, setCustomer ] = useState({ firstName });
    const handleChange = ({ target }) =>
        setCustomer(customer => ({
        ...customer,
        [target.name]: target.value
    }));
    return <form id="customer" onSubmit={() => onSubmit(customer)}>
            <label htmlFor="firstName">First name</label>
            <input
            type="text"
            name="firstName"
            id="firstName"
            value={firstName}
            onChange={handleChange}
            />

            <input
            type="text"
            name="lastName"
            />
            <input type="submit" value="Add" />
        </form>;
};