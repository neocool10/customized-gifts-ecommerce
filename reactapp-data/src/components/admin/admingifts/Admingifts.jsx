import React, { Component } from 'react';
import './admingifts.css';
import 'bootstrap/dist/css/bootstrap.css';
import Addgift from './addgift/Addgift';
import DisplayGift from './addgift/DisplayGift';
import Header from '../../header/Header';
class Admingifts extends Component {
    render() {
        return (
            <>
            <Header />
            <div className="container">
                <div className="row">
                 <div className="col-8">
                    <DisplayGift/>
                 </div>
                 <div className="col-4">
                    <Addgift/>
                </div>
                </div>
            </div>
            </>
        );
    }
}

export default Admingifts;