import { useState, useEffect } from 'react';
import { Link, useParams, useNavigate } from 'react-router-dom'
import Header from '../../header/Header';

const Editorder = () => {

  const token = "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken;
  const navigate = useNavigate();
  const { orderId } = useParams();
  const [orderInfo, setOrderInfo] = useState({
    "orderId": 10,
    "orderName": "a + red",
    "orderDescription": "asd + asd",
    "orderPrice": 600,
    "delivery": {
        "deliveryId": 9,
        "orderId": 0,
        "orderAddress": "S/367, D.R.P. line, Jail Road, Indore",
        "orderDate": "2022-10-30",
        "orderPhone": "08349577048",
        "orderEmail": "amanchoudhary1517@gmail.com",
        "orderQuantity": 3
    },
    "gift": {
        "giftId": 1,
        "giftName": "a",
        "giftImageUrl": "se",
        "giftDetails": "asd",
        "giftPrice": 100,
        "giftQuantity": 10
    },
    "user": {
        "userId": 4,
        "email": "c@c.c",
        "password": "$2a$10$IJ3Fvtkhi39jO/WV7AQYxuEZ2HqHL7ySGdguG1FNa8sdSctrRVTR2",
        "username": "cccc",
        "mobileNumber": "1234567890",
        "userRole": "User"
    },
    "theme": {
        "themeId": 2,
        "themeName": "red",
        "themeDetails": "asd",
        "themePrice": 100
    }
});
  useEffect(() => {
    loadUser()
  }, [])
  const loadUser = async () => {
    let response = await fetch(`http://localhost:8080/users/editOrder/${orderId}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "Authorization": token
      }
    })
    setOrderInfo(await response.json());
  }
  // const handleInput = (e) => {
  //     const name = e.target.name;
  //     const value = e.target.value;
  //     setOrderInfo({ ...orderInfo, [name]: value });
  // };
  // const handleSubmit = async (e) => {
  //     e.preventDefault();
  //     let response = await fetch(`http://localhost:8080/user/editOrder/${orderId}`, {
  //         method: "PUT",
  //         headers: {
  //             "Content-Type": "application/json",
  //             "Authorization": token
  //         },
  //         body: JSON.stringify(orderInfo)
  //     })
  //     if (response.ok) {
  //         navigate("/user/myorder")
  //     }
  // };

  return (
    <div>
      <Header />
      <div className='container'>
        <div className="px-4 pt-2">
          <div className="card-body  p-5">
            <h3 className="mb-3 text-center">ORDER DETAILS</h3>
            <Link className='text-decoration-none' to="/user/myorder">
              <i className="fa fa-backward i-size" aria-hidden="true"></i>
            </Link>
            <div className='row card-body shadow border-0 mt-3'>
              <div className='col '>
                <div className=" " key={orderInfo.orderId}>
                  <div className="">
                    <img className="rounded float-center" src={orderInfo.gift.giftImageUrl} width="500"  alt=''></img>
                    {/* <div className='row'>
                      <div className="col" >
                        <h5 className="mb-1">GIFT {orderInfo.gift.giftId}</h5>
                        <p className="mb-1">Name: {orderInfo.gift.giftName}</p>
                        <p className="mb-1">Price: {orderInfo.gift.giftPrice}</p>
                        <dl className="mb-1">Description: {orderInfo.gift.giftDetails}</dl>
                        <p className="mb-1">Quantity: {orderInfo.gift.giftQuantity}</p>
                      </div>
                      <div className="col">
                        <h5 className='mb-1'>THEME {orderInfo.theme.themeId}</h5>
                        <p className="mb-1">Name: {orderInfo.theme.themeName}</p>
                        <p className="mb-1">Price: {orderInfo.theme.themePrice}</p>
                        <p className="mb-1">Description: {orderInfo.theme.themeDetails}</p>
                      </div>
                    </div> */}
                  </div>
                </div>
              </div>
              <div className='col'>
                <div className="">
                  <div className="card-body">
                    <div className="col mb-3">
                      <h6>Order Name</h6>
                      <p>{orderInfo.gift.giftName} + {orderInfo.theme.themeName}</p>
                    </div>
                    <div className="mb-3">
                      <h6>Order Description</h6>
                      <p className="">{orderInfo.gift.giftDetails} + {orderInfo.theme.themeDetails}</p>
                    </div>
                    <div className="mb-3">
                      <h6>Order Price</h6>
                      <p className="">{orderInfo.orderPrice}</p>
                    </div>
                    <div className="mb-3">
                      <h6>Order Date</h6>
                      <p className="">{orderInfo.delivery.orderDate}</p>
                    </div>
                    <div className="mb-3">
                      <h6>Order Address</h6>
                      <p className="">  {orderInfo.delivery.orderAddress}</p>
                    </div>
                    <div className="mb-3">
                    <h6>Order Phone</h6>
                      <p className=""> {orderInfo.delivery.orderPhone}</p>
                    </div>
                    <div className="mb-3">
                    <h6>Order Email</h6>
                      <p className=""> {orderInfo.delivery.orderEmail} </p>
                    </div>
                    <div className="mb-3">
                    <h6>Product Quantity</h6>
                      <p className=""> {orderInfo.delivery.orderQuantity} </p>
                    </div>
                    {/* <div className="mb-3">
                      <button type="submit" className="btn btn-primary rounded-0 w-100"> EDIT ORDER</button>
                    </div> */}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Editorder;