import axios from "axios";
import { api_url } from "../../../../helper/Api_url";
import React, { Component } from "react";
import "./addgift.css";
import 'bootstrap/dist/css/bootstrap.css'

class Addgift extends Component {
  constructor(props) {
    super(props);
    this.state = {
      giftName: "",
      giftPrice: "",
      giftDetails: "",
      giftImageUrl: "",
      giftQuantity: "",
      giftId: ""
    }
    this.submitGift = this.submitGift.bind(this);

  }
  onChangeGiftData = (event) => {
    this.setState({
      ...this.state,
      [event.target.name]: event.target.value
    })
  }

  submitGift = (e) => {
    e.preventDefault();
    let addGiftData = {
      giftName: this.state.giftName,
      giftPrice: this.state.giftPrice,
      giftDetails: this.state.giftDetails,
      giftImageUrl: this.state.giftImageUrl,
      giftQuantity: this.state.giftQuantity,
      giftId: this.state.giftId
    }
    axios({
      method: 'post',
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        'Authorization': "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken,
      },
      url: `${api_url}/admin/addGift`,
      data: addGiftData
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

    return (
      <>
        <div className="px-4 pt-2">
          <div className="card rounded-0 shadow border-0">
            <div className="card-body text-center p-5">
              <h3 className="mb-3">Add Gift</h3>
              <form onSubmit={this.submitGift}>
                <div className="mb-3">
                  <input type="text" value={this.state.giftName} name="giftName"  onChange={(event) => this.onChangeGiftData(event)} className="form-control rounded-0" placeholder="enter the gift name"></input>
                </div>
                <div className="mb-3">
                  <input type="number" value={this.state.giftPrice} name="giftPrice" onChange={(event) => this.onChangeGiftData(event)} className="form-control rounded-0" placeholder="enter the gift price"></input>
                </div>
                <div className="mb-3">
                  <textarea type="text" value={this.state.giftDetails} name="giftDetails" onChange={(event) => this.onChangeGiftData(event)} className="form-control rounded-0" placeholder="enter the gift details"></textarea>
                </div>
                <div className="mb-3">
                  <input type="text" value={this.state.giftImageUrl} name="giftImageUrl" onChange={(event) => this.onChangeGiftData(event)} className="form-control rounded-0" placeholder="enter the gift image url"></input>
                </div>
                <div className="mb-3">
                  <input type="number" value={this.state.giftQuantity} name="giftQuantity" onChange={(event) => this.onChangeGiftData(event)} className="form-control rounded-0" placeholder="enter the product quantity"></input>
                </div>
                <div className="mb-3">
                  <button type="submit" className="btn btn-primary rounded-0 w-100"> ADD GIFT</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default Addgift;
