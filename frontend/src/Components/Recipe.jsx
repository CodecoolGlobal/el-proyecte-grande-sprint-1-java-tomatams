import React from "react";
import { Link } from "react-router-dom";


const Recipe = ({ recipe, onDelete }) => {
  return (
    <div>
      <div className="deleteDiv">
        {onDelete && (<Link to="/"><button type="button" id="X" onClick={() => onDelete(recipe.id) }>X</button></Link>)}
      </div>
      <img src={recipe.image} className="recipe-image" alt="Recipe" />
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
