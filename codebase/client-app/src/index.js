import React from 'react';
import { render } from 'react-dom';
import { createStore, applyMiddleware } from 'redux';
import reduxThunk from 'redux-thunk';
import { Provider } from 'react-redux';


import Layout from './component/Layout';
import reducer from './reducer';

const store = createStore(reducer, applyMiddleware(reduxThunk));

render(
    <Provider store={store} >
        <Layout />
    </Provider>, document.querySelector('#root'));
