import React from "react";
import { createSearchParams, useNavigate } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMagnifyingGlass } from "@fortawesome/free-solid-svg-icons";

const SearchBar = () => {
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const entries = [...formData.entries()];
    event.target.reset();

    navigate({
      pathname: "/search",
      search: `${createSearchParams(entries)}`,
    });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div className="search-container">
          <div className="search-box">
            <input className="search-txt" name="search" placeholder="search" />
            <input type="submit" hidden />
            <a className="search-btn" href="#">
              <FontAwesomeIcon icon={faMagnifyingGlass} />
            </a>
          </div>
          <div className="search-cooking-time">
            <input
              type="checkbox"
              name="cookingTime"
              id="cooking-time_short"
              value="SHORT"
            />
            <label htmlFor="cooking-time_short">&lt; 30 min</label>
            <input
              type="checkbox"
              name="cookingTime"
              id="cooking-time_medium"
              value="MEDIUM"
            />
            <label htmlFor="cooking-time_medium">30 - 60 min</label>
            <input
              type="checkbox"
              name="cookingTime"
              id="cooking-time_long"
              value="LONG"
            />
            <label htmlFor="cooking-time_long">60 - 90 min</label>
            <input
              type="checkbox"
              name="cookingTime"
              id="cooking-time_extra-long"
              value="EXTRA_LONG"
            />
            <label htmlFor="cooking-time_extra-long">&gt; 90 min</label>
          </div>
        </div>
      </form>
    </div>
  );
};

export default SearchBar;
