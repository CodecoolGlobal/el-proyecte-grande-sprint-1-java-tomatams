import React from "react";

const Recipe = ({ recipe }) => {

  const imageStyle = {
    backgroundImage: `url(${recipe.image})`,
    backgroundSize: "cover",
    backgroundPosition: "center",
    height: "300px"
  };

  return (
    <div className="recipe">    
    <div style={imageStyle}></div>  
    <div>
      <div className="recipe-title">{recipe.title}</div>
    </div>
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
