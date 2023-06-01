import React from "react";

const Recipe = ({ recipe }) => {

  return (
    <main>
      <div className="recipe-container">
        <h2>{recipe.title}</h2>
        <p className="recipe-preparation-text">{recipe.preparation}</p>
        <p>{recipe.creationDate}</p>
      </div>
    </main>

  )
}

export default Recipe;
