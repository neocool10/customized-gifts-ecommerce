import React, { useState, useEffect } from 'react';
import './DisplayGift.css';
import 'bootstrap/dist/css/bootstrap.css';
import { BiAddToQueue } from "react-icons/bi";
import Header from '../../header/Header';

import Modal from 'react-modal';
import { Link } from 'react-router-dom';

const DisplayGifts = () => {

    const token = "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken;
    // const navigate = useNavigate();
    const [themeInfo, setThemeInfo] = useState([]);
    const [giftInfo, setGiftInfo] = useState([]);
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [selectedTheme, setSelectedTheme] = useState([{ themeId: 1 }]);
    const [selectedGift, setSelectedGift] = useState([]);


    const load = async () => {
        let response = await fetch(`http://localhost:8080/admin/getTheme`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": token
            }
        })

        let response1 = await fetch(`http://localhost:8080/admin/getGift`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": token
            }
        })
        setThemeInfo(await response.json());
        setGiftInfo(await response1.json());

    }

    useEffect(() => {
        load()
    }, []);



    const openModal = (card) => {
        setModalIsOpen(true)
        setSelectedGift(card);
    }
    const selectTheme = ({ themeName, themePrice, themeDetails, themeId }) => {
        setSelectedTheme({
            themeName,
            themePrice,
            themeDetails,
            themeId
        })
    }
    const closeModal = () => {
        setModalIsOpen(false)
        setSelectedGift({
            giftName: "",
            giftPrice: "",
            giftDetails: "",
            giftImageUrl: "",
            giftQuantity: "",
            giftId: ""
        })
        setSelectedTheme({
            themeName: "",
            themePrice: "",
            themeDetails: "",
            themeId: ""
        })
    }


    const customStyles = {
        content: {
            top: '55%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
        },
    };


    return (
        <>
            <Header />
            <div className='p-5'>
                <div className="row ">
                    {
                        giftInfo.map((card) =>
                            <div key={card.giftId} style={{ background: "", borderRadius: "20px", cursor: "pointer" }} className="shadow border-0 m-2 col">
                                <div onClick={() => openModal(card)} className="card-body p-0  py-1 ps-3">
                                    <div className='card-body' style={{ height: '300px'}}>
                                    <img className="rounded align-center"  src={card.giftImageUrl} width="300"  alt=''></img>
                                    </div>
                                    <div style={{ height: '10%'}}>
                                    <h6 className="mb-1">Name: {card.giftName}</h6>
                                    <h6 className="mb-1">Price: {card.giftPrice}</h6>
                                    </div>
                                </div>
  {/* <div class="card">
  <img className="rounded align-center"  src={card.giftImageUrl} width="300"  alt=''></img>
      <div class="card-body">
        <h5 class="card-title">Sunset</h5>
        <h6 class="card-text">Lorem ipsum dolor sit amet consectetur, </h6>
      </div>
      </div>
      <h6 className="mb-1">Name: {card.giftName}</h6>
                                    <h6 className="mb-1">Price: {card.giftPrice}</h6> */}
                            </div>
                        )
                    }

                </div>
            </div>

            <Modal
                isOpen={modalIsOpen}
                ariaHideApp={false}
                onRequestClose={closeModal}
                style={customStyles}
                contentLabel="Example Modal"
            >
                <div className='row p-3'>
                    <div key={selectedGift.giftId} className="col">
                        <div className="card p-1 m-3 ">
                            <div className="py-3 ps-3">
                                <h6 className="mb-1"><img className="rounded float-center" src={selectedGift.giftImageUrl} width="300" alt=''></img></h6>
                                <h6 className="mb-1">Name: {selectedGift.giftName}</h6>
                                <h6 className="mb-1">Price: {selectedGift.giftprice}</h6>
                                <h6 className="mb-1">Description: {selectedGift.giftDetails}</h6>
                                <h6 className="mb-1">Quantity: {selectedGift.giftQuantity}</h6>
                            </div>
                        </div>
                        <div key={selectedTheme.themeId}>
                            <div className='card'>
                                <h3>Selected Theme</h3>
                                
                                <div className="py-3 ps-3 " style={{background: selectTheme.themeName}}>
                                    
                                    <h6 className="mb-1">Name: {selectedTheme.themeName}</h6>
                                    <h6 className="mb-1">Price: {selectedTheme.themePrice}</h6>
                                    <h6 className="mb-1">Description: {selectedTheme.themeDetails}</h6>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className='col'>
                        <h1>Select Theme</h1>
                        {/* <div className="d-flex p-2">
                            <div className="input-group">
                                <input type="text" className="form-control border-0 shadow fs-6 p-2 rounded-0" placeholder="Type here to search theme"></input>
                            </div>
                            <button type="button" className="btn ms-3 text-white rounded-0 shadow" style={{ background: "#4C80E5" }}>Search</button>
                        </div> */}


                        <div style={{ height: "500px", overflow: "scroll" }} className=" overflow-auto">

                            {
                                themeInfo.map((card) =>
                                    <div key={card.themeId} className="card shadow border-0 themeCard mt-3">
                                        <div onClick={() => selectTheme(card)} style={{ background: "", borderRadius: "20px", cursor: "pointer" }} className="card-body p-0 d-flex">
                                            <div style={{ width: "10%" }}>
                                                <div className="h-100 d-flex justify-content-center align-items-center" style={{ background: `${card.themeName}`, borderRadius: "5px", cursor: "pointer" }}>
                                                    {/* "#4C80E5" */}
                                                    <BiAddToQueue className="text-white" size={18} />
                                                </div>
                                            </div>
                                            <div className="py-3 ps-3">
                                                <h6 className="mb-1">Name: {card.themeName}</h6>
                                                <h6 className="mb-1">Price: {card.themePrice}</h6>
                                                <h6 className="mb-1">Description: {card.themeDetails}</h6>

                                            </div>
                                        </div>
                                    </div>
                                )
                            }
                        </div>
                    </div>
                </div>
                <div className="d-flex m-3">
                    <Link className="btn btn-primary rounded-0 w-100 me-2" to={`/user/placeorder/${selectedGift.giftId}+${selectedTheme.themeId}`} id="giftHomeButton" >Place Order</Link>
                    <button type="button" onClick={closeModal} className="btn btn-primary rounded-0 w-100 ms-2">Cancel</button>
                </div>
            </Modal>
        </>
    );
}

export default DisplayGifts;