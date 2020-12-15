import React from 'react';
import {NavLink} from 'react-router-dom';

const Menu = () => {
    return (
        <div className="ui inverted segment">
            <div className="ui inverted secondary pointing menu">
                <NavLink to="/" className="item" activeClassName="active" exact >
                    Home
                </NavLink>
                <NavLink to="/users" className="item" activeClassName="active">
                    Users
                </NavLink>
            </div>
        </div>
    );
}

export default Menu;