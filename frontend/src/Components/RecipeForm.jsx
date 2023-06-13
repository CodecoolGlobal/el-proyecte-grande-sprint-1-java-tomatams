const RecipeForm = ({ recipe, onSave, disabled, onCancel }) => {
  const onSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entries = [...formData.entries()];

    const recipe = entries.reduce((acc, entry) => {
      const [k, v] = entry;
      acc[k] = v;
      return acc;
    }, {});
    console.log(recipe);
    return onSave(recipe);
  };

  return (
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
        <div className="form-fields">
          <label htmlFor="cooking-time">Cooking time (minutes)</label>
          <input
            type="number"
            id="cooking-time"
            name="cooking-time"
          // defaultValue={recipe ? recipe.cooking-time : null}
          ></input>
        </div>
        <div className="form-fields">
          <label htmlFor="preparation">Preparation</label>
          <textarea id="preparation" name="preparation">
            {recipe ? recipe.preparation : null}
          </textarea>
        </div>
        <div className="form-field-buttons">
          <button type="submit" disabled={disabled}>
            {recipe ? "Update recipe" : "Create recipe"}
          </button>
          <button onClick={onCancel}>Cancel</button>
        </div>
      </div>
    </form>
  );
};
export default RecipeForm;
