import React from "react";
import { createSearchParams, useNavigate } from "react-router-dom";

const SearchBar = () => {
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const entries = [...formData.entries()];
    event.target.reset();

    navigate({
      pathname: "/search",
      search: `${createSearchParams(entries)}`
    })
  }

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input name="search" placeholder="search" />
        <input type="submit" hidden />
        <input type="checkbox" name="cookingTime" id="cooking-time_short" value="SHORT" />
        <label htmlFor="cooking-time_short">&lt; 30 min</label>
        <input type="checkbox" name="cookingTime" id="cooking-time_medium" value="MEDIUM" />
        <label htmlFor="cooking-time_medium">30 - 60 min</label>
        <input type="checkbox" name="cookingTime" id="cooking-time_long" value="LONG" />
        <label htmlFor="cooking-time_long">60 - 90 min</label>
        <input type="checkbox" name="cookingTime" id="cooking-time_extra-long" value="EXTRA_LONG" />
        <label htmlFor="cooking-time_extra-long">&gt; 90 min</label>Ł
      </form>
    </div>
  )
}

export default SearchBar;