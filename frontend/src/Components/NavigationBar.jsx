import React, { useState } from "react";
import { Link } from "react-router-dom";

const NavigationBar = ({ active, handleClick }) => {
  return (
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
          <Link to="/register">Sign Up</Link>
        </li>
        <li>
          <a href="#">Contact</a>
        </li>
      </div>
    </nav>

  )
}

export default NavigationBar;