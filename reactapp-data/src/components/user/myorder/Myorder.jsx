import "./myorder.css"
import React, { useState, useEffect } from "react";
import { AiFillInfoCircle } from "react-icons/ai";
import { AiFillDelete } from "react-icons/ai";
import { Link } from "react-router-dom";
import Header from "../../header/Header";


const Myorder = () => {
    const token = "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken;
    const [orders, setOrders] = useState([]);
    let userId = JSON.parse(localStorage.getItem('auth')).userId;
    useEffect(() => {
        loadOrders();
    },[userId]);


    const loadOrders = async () => {
        let result = await fetch(`http://localhost:8080/user/myOrderonly/${userId}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": token
            }
        })
        setOrders(await result.json());
    }

    const deleteOrder = async (id) => {
        await fetch(`http://localhost:8080/user/deleteOrder/${id}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
                "Authorization": token
            }
        })
        loadOrders();
    }


    return (
        <div>
            <Header/>
            <div>
             <table className="table-container" rules='rows'>
                     <thead className="table-head">
                         <tr>
                             <th></th>
                             <th scope="col" className="rowstyle">Gift Name</th>
                             <th scope="col" className="rowstyle">Theme Name</th>
                             <th scope="col" className="rowstyle">Price</th>
                             <th scope="col" className="rowstyle">Quanity</th>
                             <th scope="col" className="rowstyle">OrderDate</th>
                             <th scope="col" className="rowstyle"></th>
                             <th scope="col" className="rowstyle"></th>
                             <th></th>
                         </tr>
                     </thead>
                     <tbody>
                    {
                        orders.map((ord) => (
                            <tr className="align-middle" key={ord.orderId}>
                                <td className="rowstyle"><img width={"100px"} src={ord.gift.giftImageUrl}></img></td>
                                <td className="rowstyle">{ord.gift.giftName}</td>
                                <td className="rowstyle">{ord.theme.themeName}</td>
                                <td className="rowstyle">{ord.orderPrice}</td>
                                <td className="rowstyle">{ord.delivery.orderQuantity}</td>
                                <td className="rowstyle">{ord.delivery.orderDate}</td>
                                <td className="rowstyle">{ord.order}</td>  
                                <td className="rowstyle">
                                    <Link className="btn btn-outline-primary" to={`/user/editOrder/${ord.orderId}`}><AiFillInfoCircle /></Link>
                                </td>
                                <td className="rowstyle">
                                    <button className="btn btn-danger" onClick={ () => deleteOrder(ord.orderId)}><AiFillDelete /></button>
                                </td>
                            </tr>
                            ))
                    }
                     </tbody>
             </table>
         </div>
        </div>
    );
}
export default Myorder;

