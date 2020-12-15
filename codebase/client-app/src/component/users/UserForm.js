import React from 'react';
import { Link } from 'react-router-dom';
import { reduxForm, Field } from 'redux-form';

class UserForm extends React.Component {
    renderInput = ({ input, label }) => {
        return (
            <div className="field">
                <label>{label}</label>
                <input {...input} />
            </div>
        );
    }

    render() {
        return (
            <React.Fragment>
                <h3 className="ui header">{this.props.title}</h3>
                <form className="ui form" onSubmit={this.props.handleSubmit(this.props.onSubmit)}>
                    <Field name="email" component={this.renderInput} label="Email" placeholder="Type email" />
                    <Field name="firstName" component={this.renderInput} label="First name" placeholder="Type first name here" />
                    <Field name="lastName" component={this.renderInput} label="Last name" placeholder="Type last name here" />
                    
                    <Link to="/users" className="ui button negative">Cancel</Link>
                    <button className="ui button primary" type="submit">Submit</button>
                </form>
            </React.Fragment>
        );
    }
}

export default reduxForm({ form: 'userForm' })(UserForm);