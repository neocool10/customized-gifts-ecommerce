
import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import Header from '../../header/Header';

const Editorder = () => {

  const token = "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken;
  const navigate = useNavigate();
  const { themeId, giftId } = useParams();
  const [orderInfo, setOrderInfo] = useState([]);
  const [themeInfo, setThemeInfo] = useState([]);
  const [giftInfo, setGiftInfo] = useState([]);
  const [deliveryInfo, setDeliveryInfo] = useState({deliveryId: 0, orderDate: new Date().toISOString().split('T')[0]});
  useEffect(() => {
    loadTheme()
  }, []);

  const loadTheme = async () => {
    let response = await fetch(`http://localhost:8080/user/getThemeById/${themeId}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "Authorization": token
      }
    })

    let response1 = await fetch(`http://localhost:8080/user/getGiftById/${giftId}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "Authorization": token
      }
    })
    setThemeInfo(await response.json());
    setGiftInfo(await response1.json()); 
  }

  const handleInput = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setDeliveryInfo({
      ...deliveryInfo,
      [name]: value
    })
    setOrderInfo({
      delivery: deliveryInfo,
      gift: giftInfo,
      theme: themeInfo,
      user: { userId: JSON.parse(localStorage.getItem('auth')).userId }
    });
  };

  const handleSubmit = async (e) => {
    
    e.preventDefault();
    
    let response = await fetch(`http://localhost:8080/user/addOrder`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": token
      },
      body: JSON.stringify(orderInfo)
    })
    if (response.ok) {
      navigate("/user/myorder")
    }
  };

  return (
    <div>
      <Header />
      <div className='container'>
        <div className="px-4 pt-2">
          <div className="card rounded-0 shadow border-0">
            <div className="card-body text-center p-5">
              <h3 className="mb-3">ADD ORDER</h3>

              <div className="row card-body shadow border-0 themeCard mt-3">
                <div className="col">
                  <p className="mb-1"><img className="rounded float-center" src={giftInfo.giftImageUrl} width="400" height="400" alt=''></img></p>
                </div>
                <div className="col ">

                  <div className="mb-3">
                    <h5>ORDER DETAILS</h5>
                    <h6 className="">Order Name:  {giftInfo.giftName} + {themeInfo.themeName}</h6>
                    <h6 className="" >Order Description:  {giftInfo.giftDetails} + {themeInfo.themeDetails}</h6>
                    <h6 className="">Order Price:  {giftInfo.giftPrice + themeInfo.themePrice}</h6>
                    <h6 className="">Order Date:  {new Date().toISOString().split('T')[0]}</h6>
                  </div>
                  <form onSubmit={handleSubmit}>
                    <h5>ADD DELIVERY DETAILS</h5>
                    <div className="mb-3">
                      <input type="number" value={deliveryInfo.orderQuantity} name="orderQuantity" onChange={handleInput} className="form-control rounded-0" placeholder="enter the product quantity" required></input>
                    </div>
                    
                    <div className="mb-3">
                      <input type="number" value={deliveryInfo.orderPhone} name="orderPhone" onChange={handleInput} className="form-control rounded-0" placeholder="enter the Order Phone" required></input>
                    </div>
                    <div className="mb-3">
                      <input type="email" value={deliveryInfo.orderEmail} name="orderEmail" onChange={handleInput} className="form-control rounded-0" placeholder="enter the Order Email" required></input>
                    </div>
                    <div className="mb-3">
                      <textarea type="text" value={deliveryInfo.orderAddress} name="orderAddress" onChange={handleInput} className="form-control rounded-0" placeholder="enter the Order Address" required></textarea>
                    </div>
                  </form>
                </div>
              </div>
              <button type="submit" onClick={handleSubmit} className="btn btn-primary rounded-0 w-100"> ADD ORDER</button>

            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Editorder;