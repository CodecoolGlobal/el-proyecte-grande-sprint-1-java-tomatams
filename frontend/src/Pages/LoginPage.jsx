import { useState, useEffect, useContext } from "react";
import { useNavigate } from "react-router-dom";
import UserLoginForm from "../Components/User/UserLoginForm";

import { TokenContext } from "./Layout"; // always copy where token is used


const loginUser = (user) => {
  return fetch("/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(user)
  });
};


const LoginPage = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const { setToken } = useContext(TokenContext); // always copy where token is used

  const handleLogInUser = (user) => {
    setLoading(true);
    loginUser(user)
      .then((res) => {
        const headerToken = res.headers.get("Authorization");
        localStorage.setItem('token', headerToken);
        setToken(headerToken)
      })
      .then(() => {
        navigate("/");
      })
      .catch((err) => {
        throw (err);
      })
      .finally(() => {
        setLoading(false);
      })
  };

  return (
    <UserLoginForm
      onCancel={() => navigate("/")}
      disabled={loading}
      onSave={handleLogInUser} />
  )
}

export default LoginPage;