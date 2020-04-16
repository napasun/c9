import React, {useState} from 'react';

export const CustomerForm = ({ firstName,
                                 lastName,
                                 phoneNumber,
                                 onSubmit,
                                 fetch }) => {
    const [customer, setCustomer] = useState({firstName});

    const handleChangeFirstName = ({ target }) =>
        setCustomer(customer => ({
            ...customer,
            firstName: target.value
        }));

    const handleSubmit = () => {
        onSubmit(customer);
        //window.fetch(...);
        fetch('/customers', {
            method: 'POST',
            credentials: 'same-origin',
            headers: { 'Content-Type': 'application/json' }
        });
    };

    return (
        <form id="customer" onSubmit={handleSubmit}>
            <label htmlFor="firstName">First name</label>
            <input
                type="text"
                name="firstName"
                id="firstName"
                value={firstName}
                onChange={handleChangeFirstName}
            />
            <input
                type="text"
                name="lastName"
            />
            <input type="submit" value="Add" />
        </form>
    );
};

CustomerForm.defaultProps = {
    fetch: async () => {}
};
