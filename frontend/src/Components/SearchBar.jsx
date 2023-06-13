import React, { useState } from "react";
import { createSearchParams, useNavigate } from "react-router-dom";

const SearchBar = ({ onSubmit }) => {
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const entries = [...formData.entries()];
    event.target.reset();

    navigate({
      pathname: "/search",
      search: `?${createSearchParams(entries)}`
    })
  }

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input name="search" placeholder="search" />
        <input type="submit" hidden />
      </form>
    </div>
  )
}

export default SearchBar;