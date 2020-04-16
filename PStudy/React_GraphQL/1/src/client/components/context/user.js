import React, { Component, createContext } from 'react';
const { Provider, Consumer } = createContext();

// export class UserProvider extends Component {
//     render() {
//       const { children } = this.props;
//       const user = {
//         username: "Test User",
//         avatar: "/uploads/avatar1.png"
//       };
//       return (
//         <Provider value={user}>
//           {children}
//         </Provider>
//       );
//     }
// }

// export class UserConsumer extends Component {
//     render() {
//         const { children } = this.props;
//         return (
//         <Consumer>
//             {user => React.Children.map(children, function(child){
//             return React.cloneElement(child, { user });
//             })}
//         </Consumer>
//         )
//     }
// }

import { ApolloConsumer } from 'react-apollo';

export class UserConsumer extends Component {
    render() {
        const { children } = this.props;
        return (
            <ApolloConsumer>
                {
                    /* {client => {
                    // Use client.readQuery to get the current logged in user.
                    const user = {
                        username: "Test User",
                        avatar: "/uploads/avatar1.png"
                    };
                    return React.Children.map(children, function(child){
                        return React.cloneElement(child, { user });
                    });
                    }} */
                client => {
                    const {currentUser} = client.readQuery({ query: GET_CURRENT_USER});
                    return React.Children.map(children, function(child){
                        return React.cloneElement(child, { user: currentUser });
                    });
                }}
            </ApolloConsumer>
        )
    }
}