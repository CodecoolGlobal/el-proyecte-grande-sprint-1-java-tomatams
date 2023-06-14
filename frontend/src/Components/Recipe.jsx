import React from "react";

const Recipe = ({ recipe }) => {
  console.log("Recipe", typeof recipe.ingredientDTOS);
  return (
    <div>
      <h2>{recipe.title}</h2>
      <div>
        {recipe.ingredientDTOS.map((ingredient, index) => (
          <div key={ingredient.id}>
            <h3>{ingredient.amount}</h3>
            <h3>{ingredient.unit}</h3>
            <h3>{ingredient.name}</h3>
          </div>
        ))}
      </div>
      <p className="recipe-preparation-text">{recipe.preparation}</p>
      <p>{recipe.creationDate}</p>
    </div>

  )
}

export default Recipe;
