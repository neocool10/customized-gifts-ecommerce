import './dashboard.css';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { signupValidation } from '../../../helper/Authentication';
import Header from '../../header/Header';
function Dashboard() {
    const token = "Bearer " + JSON.parse(localStorage.getItem('auth')).jwtToken;
    const [users, setUsers] = useState([]);
    const [userInfo, setUserInfo] = useState({
        email: '',
        username: '',
        mobileNumber: '',
        password: '',
        confirmPassword: '',
        userRole: ''
    });
    const [errors, setErrors] = useState({ userRole: '', email: "", username: "", mobileNumber: "", password: "", confirmPassword: "" });
    useEffect(() => {
        loadAllUsers();
    }, []);
    const loadAllUsers = async () => {
        let result = await fetch("http://localhost:8080/superAdmin/getAllUsers", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": token
            }
        })
        setUsers(await result.json());
    }
    const deleteUser = async userId => {
        await fetch(`http://localhost:8080/superAdmin/deleteUser/${userId}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
                "Authorization": token
            }
        })
        loadAllUsers();
    };
    const handleBlur = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        if (name === 'userRole' && value === '') {
            errors.userRole = 'Please select one';
        }
        else if (name === 'email' && userInfo.email === '') {
            errors.email = 'Please enter Email';
        }
        else if (name === 'username' && userInfo.username === '') {
            errors.username = 'Please enter your username';
        }
        else if (name === 'mobileNumber' && userInfo.mobileNumber === '') {
            errors.mobileNumber = 'Mobile number is required';
        }
        else if (name === 'password' && userInfo.password === '') {
            errors.password = 'Please enter pPassword';
        }
        else if (name === 'confirmPassword' && userInfo.confirmPassword === '') {
            errors.confirmPassword = 'Please confirm your password';
        }
    };
    const handleSubmit = async (e) => {
        e.preventDefault();
        const errorsObj = signupValidation(userInfo);
        setErrors(errorsObj.errors);
        if (!errorsObj.status) {
            await fetch("http://localhost:8080/superAdmin/addUser", {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": token
                },
                body: JSON.stringify(userInfo)
            })
            loadAllUsers();
            setUserInfo({ email: "", username: "", mobileNumber: "", password: "", confirmPassword: "" });
        }
    };
    const handleInput = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setUserInfo({ ...userInfo, [name]: value });

        if (name === 'email') { errors.email = '' }
        else if (name === 'username') { errors.username = '' }
        else if (name === 'mobileNumber') { errors.mobileNumber = '' }
        else if (name === 'password') {
            errors.password = '';
            errors.confirmPassword = '';
        }
        else if (name === 'confirmPassword') {
            errors.confirmPassword = '';
        }
        else if (name === 'userRole') { errors.userRole = '' }
    };
    return (
        <>
            <Header />
            <table className="table table-container" rules='rows'>
                <thead className="table-head">
                    <tr>
                        <th scope="col">Id</th>
                        <th className='username-width' scope="col">username</th>
                        <th className='email-width' scope="col">Email</th>
                        <th className='mobile-width' scope="col">Mobile Number</th>
                        <th scope="col">User Role</th>
                        <th scope='col'>Actions</th>
                    </tr>
                </thead>
                <tbody className='table-body'>
                    {
                        users.map((user, index) => (
                            <tr key={index}>
                                <th scope="row">{index + 1}</th>
                                <td>{user.username}</td>
                                <td>{user.email}</td>
                                <td>{user.mobileNumber}</td>
                                <td>{user.userRole}</td>
                                <td><Link to={`/superAdmin/editUser/${user.userId}`} className='px-2 i-size'>
                                    <i className="fa fa-pencil-square-o" aria-hidden="true"></i></Link>
                                    <button className=' border-0 bg-white text-danger i-size' onClick={() => deleteUser(user.userId)}  >
                                        <i className="fa fa-trash" aria-hidden="true"></i></button>
                                </td>
                            </tr>
                        ))
                    }

                </tbody>
            </table>

            <div className="box bg-body add-user">
                <div className='pt-3 text-dec'>
                    <h3>Add a user</h3>
                </div>
                <form id='addUserForm' action='' onSubmit={handleSubmit}>
                    <select onChange={handleInput} onBlur={handleBlur} name='userRole' className="input-field mt-3" aria-label="Default select example">
                        <option value="">Select admin/user</option>
                        <option value="Admin">Admin</option>
                        <option value="User">User</option>
                    </select>
                    <div className='errors'>{errors.userRole}</div>
                    <div className="pt-3">
                        <input className="input-field"
                            value={userInfo.email} onChange={handleInput} onBlur={handleBlur} placeholder="Enter email" type="email"
                            name="email" autoComplete='off' id="email" />
                    </div>
                    <div className='errors'>{errors.email}</div>


                    <div className="pt-3 ">
                        <input className="input-field"
                            value={userInfo.username} onChange={handleInput} onBlur={handleBlur} placeholder="Enter username" type="text"
                            name="username" autoComplete='off' id="username" />
                    </div>
                    <div className='errors'>{errors.username}</div>


                    <div className="pt-3 ">
                        <input className="input-field"
                            value={userInfo.mobileNumber} onChange={handleInput} onBlur={handleBlur} placeholder="Enter Mobilenumber" type="text"
                            name="mobileNumber" autoComplete='off' id="mobileNumber" />
                    </div>
                    <div className='errors'>{errors.mobileNumber}</div>

                    <div className="pt-3 ">
                        <input className="input-field"
                            value={userInfo.password} onChange={handleInput} onBlur={handleBlur} placeholder="Password" type="password"
                            name="password" autoComplete='off' id="password" />
                    </div >
                    <div className='errors'>{errors.password}</div>

                    <div className="pt-3 ">
                        <input className="input-field"
                            value={userInfo.confirmPassword} onChange={handleInput} onBlur={handleBlur} placeholder="Confirm Password" type="password"
                            name="confirmPassword" autoComplete='off' id="confirmPassword" />
                    </div>
                    <div className='errors'>{errors.confirmPassword}</div>

                    <div className='pt-4 pb-4'>
                        <button id="addButtton" className="button" type="submit">
                            Add
                        </button>
                    </div>
                </form>
            </div>

        </>

    )
}
export default Dashboard;