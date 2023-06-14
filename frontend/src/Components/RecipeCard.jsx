import React from "react";

const RecipeCard = ({ recipe }) => {

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
    </div>
  )
}

export default RecipeCard;
