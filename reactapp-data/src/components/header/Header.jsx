import { isAuthenticatedIsAdmin, isAuthenticatedIsSuperadmin, isAuthenticatedIsUser } from "../../helper/Authentication";
import { Link, useNavigate } from 'react-router-dom';
import './header.css';
import { AiOutlineCoffee } from "react-icons/ai";
function Header() {
    const navigate = useNavigate();
    const handleLogout = () => {
        localStorage.clear();
        navigate("/login");
    }
    return (
        <header className='top-nav sticky-top'>
            {isAuthenticatedIsAdmin() &&
                <>
                <div className="container" >
                        <Link className='subj link' to="/admin/home"><AiOutlineCoffee></AiOutlineCoffee>CUP GIFTS</Link>
                        <ul className='list'>
                            <li><button className='nav-list-item link' id="logout" onClick={handleLogout} >Logout</button></li>
                            <li><Link className='nav-list-item link' id="adminOrders" to="/admin/getAllOrders">ORDERS</Link></li>
                            <li><Link className='nav-list-item link' id="adminTheme" to="/admin/theme">THEMES</Link></li>
                            <li><Link className='nav-list-item link' id="adminGifts" to="/admin/gift">GIFTS</Link></li>
                            {/* <li><Link className="nav-list-item link" id="adminHome" to="/admin/home">Home</Link></li> */}
                        </ul>
                </div>
                </>
            }
            {isAuthenticatedIsUser() &&
                <>
                <div className="container">
                    <Link className='subj link' to="/user/gifts"><AiOutlineCoffee></AiOutlineCoffee>CUP GIFTS</Link>
                    {/* <input type="text" className="subj form-control border-0 shadow fs-6 p-2 rounded-3" style={{width: '50%'}} placeholder="Type here to search theme"></input> */}
                    <ul className='list'>
                        <li><button className='nav-list-item link rounded-3' style={{background: 'red'}} id="logout" onClick={handleLogout} >Logout</button></li>
                        <li><Link className='nav-list-item link' id="myOrderButton" to="/user/myorder">MY ORDERS</Link></li>
                
                        <li><Link className="nav-list-item link" id="giftHomeButton" to="/user/gifts">GIFTS</Link></li>
                        {/* <li><Link className="nav-list-item link" id="giftHomeButton" to="/user/home">Home</Link></li> */}
                    </ul>
                </div>
                </>
            }
            {isAuthenticatedIsSuperadmin() &&
                <>
                <div className="container">
                    <Link className='subj link' to="/superAdmin/getAllUsers"><AiOutlineCoffee></AiOutlineCoffee>CUP GIFTS</Link>
                    <ul className='list'>
                        <li><button className='nav-list-item link' id="logout" onClick={handleLogout} >Logout</button></li>
                        <li><Link className='nav-list-item link' id="getUsersButton" to="/superAdmin/getAllUsers">Users</Link></li>
                    </ul>
                </div>
                </>
            }
        </header>
    )
}
export default Header;