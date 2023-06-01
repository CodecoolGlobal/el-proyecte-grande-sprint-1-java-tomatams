import React from "react";

const Recipe = ({ recipe }) => {

  return (
    <div>
      <h2>{recipe.title}</h2>
      <p className="recipe-preparation-text">{recipe.preparation}</p>
      <p>{recipe.creationDate}</p>
    </div>

  )
}

export default Recipe;
