import { useState} from "react";
import { useNavigate} from "react-router-dom";
import UserForm from "../Components/User/UserRegistrationForm";

const createUser = (user) => {
  return fetch("/users/add", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(user)
  });
};


const UserCreator = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const handleCreateUser = (user) => {
    setLoading(true);
    createUser(user)
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
    <UserForm
    onCancel={()=> navigate("/")}
    disabled={loading}
    onSave= {handleCreateUser}/>
  )
}

export default UserCreator;