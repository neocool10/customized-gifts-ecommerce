import React, { Component } from 'react';
import './homepage.css';
import 'bootstrap/dist/css/bootstrap.css';
import { BiEdit } from "react-icons/bi";
import { RiDeleteBin5Line } from "react-icons/ri";
import { api_url } from '../../../helper/Api_url';
import axios from 'axios';
import Modal from 'react-modal';
import Header from '../../header/Header';
class Homepage extends Component {

   

    render() {
        const customStyles = {
            content: {
                top: '50%',
                left: '50%',
                right: 'auto',
                bottom: 'auto',
                marginRight: '-50%',
                transform: 'translate(-50%, -50%)',
            },
        };
        return (
            <>
                <Header/>
                <h1>HOME</h1>
            </>
        );
    }
}

export default Homepage;