import React, { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../images/Logo.png";
import NavigationBar from "./NavigationBar";
import SearchBar from "./SearchBar";
import ProfileNavBar from "./SignOut/ProfileNavBar";

const Header = () => {
  const [active, setActive] = useState("inactive");
  const [open, setOpen] = useState("closed");
  const [show, setShow] = useState("closed");

  const handleClick = () => {
    setActive(active === "active" ? "inactive" : "active");
  };
  const handleOpen = () => {
    setOpen(open === "open" ? "closed" : "open");
  };
  const handleShow = () => {
    setShow(show === "shown" ? "unshown" : "shown");
  };
  return (
    <header>
      <ProfileNavBar />
      <Link to={`/`} style={{ textDecoration: 'none' }}>
        <div className="header-container">
          <img id="logo-img" src={Logo} alt="website-logo" width="300" />
        </div>
      </Link>
      <NavigationBar active={active} handleClick={handleClick} />
      <SearchBar open={open} handleOpen={handleOpen} show={show} handleShow={handleShow} />
    </header>
  );
};

export default Header;
