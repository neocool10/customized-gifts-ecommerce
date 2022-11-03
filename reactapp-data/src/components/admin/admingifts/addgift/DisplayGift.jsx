import React, { Component } from 'react';
import './DisplayGift.css';
import 'bootstrap/dist/css/bootstrap.css';
import { BiEdit } from "react-icons/bi";
import { RiDeleteBin5Line } from 'react-icons/ri';
import { api_url } from '../../../../helper/Api_url';
import axios from 'axios';
import Modal from 'react-modal';
class DisplayGift extends Component {

    constructor(props) {
        super(props);
        this.state = {
            giftCards: [],
            modalIsOpen: false,
            giftName: "",
            giftPrice: "",
            giftDetails: "",
            giftImageUrl: "",
            giftQuantity: "",
            giftId: ""
        }
    }

    componentDidMount() {
        axios({
            method: 'get',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken
            },
            url: `${api_url}/admin/getGift`,
        })
            .then((response) => {
                console.log(response.data);
                this.setState({ ...this.state, giftCards: response.data })
            })
            .catch((err) => {
                console.log(err);
            })

    }

    deleteGift = (giftId) => {
        axios({
            method: 'delete',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken
            },
            url: `${api_url}/admin/deleteGift/${giftId}`,
        })
            .then((response) => {
                console.log(response.data);
                window.location.reload(true);
            })
            .catch((err) => {
                console.log(err);
            })
    }
    openModal = ({ giftPrice, giftName, giftDetails, giftImageUrl, giftQuantity, giftId }) => {
        this.setState({
            ...this.state,
            modalIsOpen: true,
            giftName,
            giftPrice,
            giftDetails,
            giftImageUrl,
            giftQuantity,
            giftId
        })
    }

    closeModal = () => {
        this.setState({
            ...this.state,
            modalIsOpen: false,
            giftName: "",
            giftPrice: "",
            giftDetails: "",
            giftImageUrl: "",
            giftQuantity: "",
            giftId: ""
        })
    }
    onChange = (event) => {
        this.setState({
            ...this.state,
            [event.target.name]: event.target.value
        })
    }
    submitEditGift = (event) => {
        event.preventDefault();
        const editGiftData = {
            giftId: this.state.giftId,
            giftName: this.state.giftName,
            giftImageUrl: this.state.giftImageUrl,
            giftDetails: this.state.giftDetails,
            giftPrice: this.state.giftPrice,
            giftQuantity: this.state.giftQuantity
        }
        axios({
            method: 'put',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken
            },
            url: `${api_url}/admin/editGift/${this.state.giftId}`,
            data: editGiftData
        })
            .then((response) => {
                console.log(response.data);
                window.location.reload(true);
            })
            .catch((err) => {
                console.log(err);
            })
    }

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

                <div className="d-flex p-2">
                    <div className="input-group">
                        <input type="text" className="form-control border-0 shadow fs-6 p-2 rounded-0" placeholder="Type here to search gift"></input>
                    </div>
                    <button type="button" className="btn ms-3 text-white rounded-0 shadow" style={{ background: "#4C80E5" }}>Search</button>
                </div>
                        <div className="gift-card-container p-2 my-3">
                            {
                                this.state.giftCards.map((card) =>
                                    <div key={card.giftId} className="card shadow border-0 giftCard mt-3">
                                        <div className="card-body p-0 d-flex">
                                            <div className="py-3 ps-3" style={{ width: "95%" }}>
                                                <p className="mb-1"><img src={card.giftImageUrl} width="200" height="200" alt=''></img></p>
                                                <p className="mb-1">Name: {card.giftName}</p>
                                                <p className="mb-1">Price: {card.giftPrice}</p>
                                                <p className="mb-1">Description: {card.giftDetails}</p>
                                                <p className="mb-1">Quantity: {card.giftQuantity}</p>
                                            </div>
                                            <div style={{ width: "5%" }}>
                                                <div className="h-50 d-flex justify-content-center align-items-center" onClick={() => this.openModal(card)} style={{ background: "#4C80E5", borderTopRightRadius: "5px", cursor: "pointer" }}>
                                                    <BiEdit className="text-white" size={18}  />
                                                </div>
                                                <div className="h-50 d-flex justify-content-center align-items-center" onClick={() => this.deleteGift(card.giftId)} style={{ background: "#E03E1F", borderBottomRightRadius: "5px", cursor: "pointer" }}>
                                                    <RiDeleteBin5Line className="text-white" size={18} />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                )
                            }
                        </div>
                <Modal
                    isOpen={this.state.modalIsOpen}
                    ariaHideApp={false}
                    onRequestClose={this.closeModal}
                    style={customStyles}
                    contentLabel="Example Modal"
                >
                    <div className="card-body text-center p-5">
                        <h3 className="mb-3">Edit Gift</h3>
                        <form onSubmit={this.submitEditGift}>
                            <div className="mb-3">
                                <input type="text" onChange={(event) => this.onChange(event)} value={this.state.giftName} name="giftName" className="form-control rounded-0" placeholder="Enter name"></input>
                            </div>
                            <div className="mb-3">
                                <input type="number" onChange={(event) => this.onChange(event)} value={this.state.giftPrice} name="giftPrice" className="form-control rounded-0" placeholder="Enter price"></input>
                            </div>
                            <div className="mb-4">
                                <textarea type="text" onChange={(event) => this.onChange(event)} value={this.state.giftDetails} name="giftDetails" className="form-control rounded-0" placeholder="Enter desciption"></textarea>
                            </div>
                            <div className="mb-3">
                                <input type="text" onChange={(event) => this.onChange(event)} value={this.state.giftImageUrl} name="giftImageUrl" className="form-control rounded-0" placeholder="Enter Image Url"></input>
                            </div>
                            <div className="mb-3">
                                <input type="text" onChange={(event) => this.onChange(event)} value={this.state.giftQuantity} name="giftQuantity" className="form-control rounded-0" placeholder="Enter Quantity"></input>
                            </div>
                            <div className="d-flex">
                                <button type="submit" className="btn btn-primary rounded-0 w-100 me-2">Submit</button>
                                <button type="button" onClick={this.closeModal} className="btn btn-primary rounded-0 w-100 ms-2">Cancel</button>
                            </div>
                        </form>
                    </div>
                </Modal>
            </>
        );
    }
}

export default DisplayGift;