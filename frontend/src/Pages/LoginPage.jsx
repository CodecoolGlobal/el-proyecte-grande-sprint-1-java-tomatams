import { useState, useEffect, useContext} from "react";
import { useNavigate} from "react-router-dom";
import UserLoginForm from "../Components/User/UserLoginForm";

import { TokenContext } from "./Layout"; // always copy where token is used


const fetchUser = (user, token) => {
  return fetch("/users/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      //"Authorization": `Bearer ${token}` // always copy where token is used
    },
    body: JSON.stringify(user)
  }
  ).then((res) => res.json());
};


const LoginPage = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  
  const { token, setToken } = useContext(TokenContext); // always copy where token is used

    useEffect(() => {
    localStorage.setItem('token', JSON.stringify(token));
    }, [token]);

  const handleLogInUser = (user) => {
    setLoading(true);
    fetchUser(user, token)
    .then((res) => {setToken(res.token)})
    .then(() => {
      navigate("/");
    })
    .catch((err) => {
      throw(err);
    })
    .finally(()=> {
      setLoading(false);
    })
  };

  return (
    <UserLoginForm
    onCancel={()=> navigate("/")}
    disabled={loading}
    onSave= {handleLogInUser}/>
  )
}

export default LoginPage;