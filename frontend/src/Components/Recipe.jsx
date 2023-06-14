import React from "react";
import { Link } from "react-router-dom";


const Recipe = ({ recipe, onDelete }) => {

  const imageStyle = {
    backgroundImage: `url(${recipe.image})`,
    backgroundSize: "cover",
    backgroundPosition: "center",
    height: "300px"
  };

  return (
    <div className="recipe">    
      <div>
            <div className="deleteDiv">
              {onDelete && (<Link to="/"><button type="button" id="X" onClick={() => onDelete(recipe.id) }>X</button></Link>)}
      </div>

      <div style={imageStyle}></div>  


      <div className="recipe-title">{recipe.title}</div>

      <div>
      <table className="recipe-table">
        <thead>
          <tr>
            <th>Amount</th>
            <th>Unit</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          {recipe.ingredientDTOS.map((ingredient, index) => (
            <tr key={ingredient.id}>
              <td>{ingredient.amount}</td>
              <td>{ingredient.unit}</td>
              <td>{ingredient.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>

      <p className="recipe-preparation-text">{recipe.preparation}</p>

      <p>{recipe.creationDate}</p>

    </div>
    </div>
  )
}

export default Recipe;
