import React, { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../Logo.png";
import NavigationBar from "./NavigationBar";
import SearchBar from "./SearchBar";

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
      <NavigationBar active={active} handleClick={handleClick} />
      <SearchBar />
    </header>
  );
};

export default Header;
