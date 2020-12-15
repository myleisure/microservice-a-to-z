import React from 'react';
import { Router, Route, Switch } from 'react-router-dom';

import Menu from './common/Menu';
import Home from './common/Home';
import UserList from './users/UserList';
import UserAdd from './users/UserAdd';

import history from '../history';

const Layout = () => (
    <Router history={history}>
        <div className="ui container">
            <Menu />
        </div>
        <div className="ui container">
            <Switch>
                <Route path="/users/add" exact component={UserAdd} />
                <Route path="/users" exact component={UserList} />
                <Route path="/" exact component={Home} />
            </Switch>
        </div>
    </Router>

);

export default Layout;