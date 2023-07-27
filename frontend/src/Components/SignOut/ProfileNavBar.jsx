import jwt_decode from "jwt-decode";
import { Link } from "react-router-dom";
import Logout from "../../images/Logout.png"

const ProfileNavBar = ({token, logout}) => {
    let bareToken = token.replace("Bearer ","");
    let decodedToken = jwt_decode(bareToken);
    return (
        <div className="profile">
            <h4>Hello {decodedToken.sub}!</h4>
            <Link to={"/profile"}><h4>View Profile</h4></Link>
            <button onClick={logout}>Log out <img src={Logout} alt="Logout" width="15" height="15"/></button>
        </div>
    )
};

export default ProfileNavBar;