import jwt_decode from "jwt-decode";
import { useState, useEffect, useContext } from "react";
import { useNavigate } from "react-router-dom";
import UserRegistrationForm from "../Components/User/UserRegistrationForm";

import { TokenContext } from "./Layout"; // always copy where token is used

const updateUser = (user, token) => {
  console.log("update USER", user);
  return fetch("/users/update", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      "Authorization": token ? token : ""
    },
    body: JSON.stringify(user)
  });
};

const ProfilePage = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const { token } = useContext(TokenContext); // always copy where token is used
  const [user, setUser] = useState(null);

  useEffect(() => {
    console.log("PROFILEPAGE", token);
    if (token !== null && token !== "" && token.startsWith("Bearer ")) {
      let bareToken = token.replace("Bearer ", "");
      const decodedToken = jwt_decode(bareToken);
      console.log(jwt_decode(bareToken));
      setUser({
        "name": decodedToken.sub,
        "email": decodedToken.email
      });
    } else {
      console.log("Invalid token format.");
    }
  }, [token])
  console.log(user);

  const handleupdateUser = (user) => {
    setLoading(true);
    updateUser(user, token)
      .then((res) => {
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
    <UserRegistrationForm
      user={user}
      onCancel={() => navigate("/")}
      disabled={loading}
      onSave={handleupdateUser} />
  )
}

export default ProfilePage;