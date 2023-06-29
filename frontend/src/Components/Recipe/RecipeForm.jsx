import { useState } from "react";
import IngredientList from "../Ingredient/IngredientList";

const RecipeForm = ({ recipe, onSave, disabled, onCancel }) => {
  const [newIngredients, setnewIngredients] = useState([]);

  const onSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entries = [...formData.entries()];

    let recipe = entries.reduce((acc, entry) => {
      const [k, v] = entry;
      acc[k] = v;
      return acc;
    }, {});

    recipe.ingredients = newIngredients;
    return onSave(recipe);
  };

  return (<main>

    <form onSubmit={onSubmit}>
      <div className="form-container">
        <div className="form-fields">
          <label htmlFor="title">Recipe title</label>
          <input
            id="title"
            name="title"
            defaultValue={recipe ? recipe.title : null}
          ></input>
        </div>
        <IngredientList id="ingredients" name="ingredients" addIngredient={setnewIngredients}>
          {recipe ? recipe.ingredients = newIngredients : null}
        </IngredientList>

        <div className="form-fields">
          <label htmlFor="cooking-time">Cooking time (minutes)</label>
          <input
            type="number"
            id="cooking-time"
            name="cooking-time"
            defaultValue={recipe ? recipe.cookingTime : null}
          ></input>
        </div>

        <div className="form-fields">
          <label htmlFor="image">The Url of image</label>
          <input
            type="text"
            id="image"
            name="image"
          ></input>
        </div>

        <div className="form-fields">
          <label htmlFor="preparation">Preparation</label>
          <textarea id="preparation" name="preparation">
            {recipe ? recipe.preparation : null}
          </textarea>
        </div>

        <div className="form-field-buttons">
          <button className="row-button" type="submit" disabled={disabled}>
            {recipe ? "Update recipe" : "Create recipe"}
          </button>
          <button className="row-button" onClick={onCancel}>Cancel</button>
        </div>
      </div>
    </form>
  </main>
  );
};
export default RecipeForm;
