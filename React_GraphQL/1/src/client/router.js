import React, { Component } from 'react';
import LoginRegisterForm from './components/loginregister';
import Main from './Main';
import { BrowserRouter as Router, Route, Redirect, Switch } from 'react-router-dom';
import User from './User';

const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route {...rest} render={(props) => (
        rest.loggedIn === true
            ? <Component {...props} />
            : <Redirect to={{
                pathname: '/',
                state: { from: props.location }
            }} />
    )} />
);

const LoginRoute = ({ component: Component, ...rest }) => (
    <Route {...rest} render={(props) => (
        rest.loggedIn === false
            ? <Component {...props} />
            : <Redirect to={{
                pathname: (typeof props.location.state !== typeof undefined) ? props.location.state.from.pathname : '/app',
            }} />
    )} />
)

class NotFound extends Component {
    render() {
        return (
            <Redirect to="/" />
        );
    }
}

export default class Routing extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    {/* <Route path="/app" component={() => <Main changeLoginState={this.props.changeLoginState} />} /> */}
                    <PrivateRoute path="/app" component={() => <Main changeLoginState={this.props.changeLoginState} />} loggedIn={this.props.loggedIn} />
                    <PrivateRoute path="/user/:username" component={props => <User {...props} changeLoginState={this.props.changeLoginState} />} loggedIn={this.props.loggedIn} />
                    <LoginRoute exact path="/" component={() => <LoginRegisterForm changeLoginState={this.props.changeLoginState} />} loggedIn={this.props.loggedIn} />
                    <Route component={NotFound} />{/* path 속성이 없을 경우 모든 경로*/}
                </Switch>
            </Router>
        )
    }
}