import jwt_decode from "jwt-decode";
import { useContext, useEffect, useState } from "react";
import { TokenContext } from "../../Pages/Layout"; // always copy where token is used
import { Link } from "react-router-dom";
import Logout from "../../images/Logout.png"

const ProfileNavBar = ({ logout }) => {
    const { token } = useContext(TokenContext);
    const [decodedToken, setDecodedToken] = useState({ "sub": "Guest" });

    useEffect(() => {
        console.log("PROFILENAVBAR", token);
        if (token !== null && token !== "" && token.startsWith("Bearer ")) {
            let bareToken = token.replace("Bearer ", "");
            setDecodedToken(jwt_decode(bareToken));
            console.log(decodedToken);
        } else {
            console.log("Invalid token format.");
        }
    }, [token])

    return (
        <div className="profile">
            <h4>Hello {decodedToken.sub}!</h4>
            <Link to={"/profile"}><h4>View Profile</h4></Link>
            <button onClick={logout}>Log out <img src={Logout} alt="Logout" width="15" height="15" /></button>
        </div>
    )
};

export default ProfileNavBar;