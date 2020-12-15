import React from 'react';
import { Link } from 'react-router-dom';

class UserList extends React.Component {
    render() {
        return (
            <div className="ui container">
                <h2 className="ui header">List of all users</h2>
                
                <table className="ui unstackable table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Status</th>
                            <th className="right aligned">Notes</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>John</td>
                            <td>Approved</td>
                            <td className="right aligned">None</td>
                        </tr>
                        <tr>
                            <td>Jamie</td>
                            <td>Approved</td>
                            <td className="right aligned">Requires call</td>
                        </tr>
                        <tr>
                            <td>Jill</td>
                            <td>Denied</td>
                            <td className="right aligned">None</td>
                        </tr>
                    </tbody>
                </table>
                <Link to="/users/add" className="ui button primary">Add user</Link>
            </div>
        );
    }
}

export default UserList;