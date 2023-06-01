import React from "react";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <header>
      <div className="container">
        <h1>Second day of Pet Project</h1>
        <Link to="/create">
        <button>Create new recipe</button>  
        </Link>
      </div>
    </header>
  )
}

export default Header;