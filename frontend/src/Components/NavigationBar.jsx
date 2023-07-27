import React, { useState } from "react";
import { Link } from "react-router-dom";
import { TokenContext } from "../Pages/Layout"; // always copy where token is used
import { useContext } from "react";


const NavigationBar = ({ active, handleClick }) => {
  const { token } = useContext(TokenContext);
  return (
    <nav>
      <div className={`navigation ${active}`} onClick={handleClick}>
        <span className={`toggle-menu ${active}`} onClick={handleClick}></span>

        <li>
          <Link to="/create">Add new recipe</Link>
        </li>
        {!token && <li>
          <Link to="/register">Sign Up</Link>
        </li>}
        {!token && <li>
          <Link to="/login">Log In</Link>
        </li>}
        {token && <li>
          <a href="/profile">Profile</a>
        </li>}
        <li>
          <a href="#">Contact</a>
        </li>
      </div>
    </nav>

  )
}

export default NavigationBar;