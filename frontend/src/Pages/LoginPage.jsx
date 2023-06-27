import { useState} from "react";
import { useNavigate} from "react-router-dom";
import UserLoginForm from "../Components/User/UserLoginForm";

const fetchUser = (user) => {
  return fetch("/users/login", {
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

  const handleLogInUser = (user) => {
    setLoading(true);
    fetchUser(user)
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