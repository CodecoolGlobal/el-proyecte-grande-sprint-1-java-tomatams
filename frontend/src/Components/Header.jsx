import React, { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../Logo.png";

const Header = () => {
  const [active, setActive] = useState("inactive");

  const handleClick = () => {
    setActive(active === "active" ? "inactive" : "active");
  };
  return (
    <header>
      <Link to={`/`} style={{ textDecoration: 'none' }}>
        <div className="header-container">
          <img id="logo-img" src={Logo} alt="website-logo" width="300" />
        </div>
      </Link>
      <nav>
        <div className={`navigation ${active}`} onClick={handleClick}>
          <span className={`toggle-menu ${active}`} onClick={handleClick}></span>

          <li>
            <Link to="/create">Add new recipe</Link>
          </li>
          <li>
            <a href="#">About us</a>
          </li>
          <li>
            <a href="#">User</a>
          </li>
          <li>
            <a href="#">Contact</a>
          </li>
        </div>
      </nav>
    </header>
  );
};

export default Header;
