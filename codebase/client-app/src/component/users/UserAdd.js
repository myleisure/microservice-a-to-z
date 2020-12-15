import React from 'react';

import UserForm from './UserForm';

class UserAdd extends React.Component {
    onSubmit = user => {
        alert(JSON.stringify(user));
    }
    render(){
        return (
            <UserForm title="Add user" onSubmit={this.onSubmit} />
        )
    }
}

export default UserAdd;