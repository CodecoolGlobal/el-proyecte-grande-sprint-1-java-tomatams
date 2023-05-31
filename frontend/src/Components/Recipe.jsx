import React from "react";

const Recipe = ({recipe}) => {

  return (
      <div>
        <h2>{recipe.title}</h2>
        <p>{recipe.preparation}</p>
        <p>{recipe.creationDate}</p>
      </div>

  )
}

export default Recipe;
