import React from "react";
import { Link } from "react-router-dom";
import Logo from "../Logo.png";

const Header = () => {
  return (
    <header>
      <div className="header-container">
        <img id="logo-img" src={Logo} alt="website-logo" width="300" />
        <Link to="/create">
          <button>Create new recipe</button>
        </Link>
      </div>
    </header>
  )
}

export default Header;