const RecipeForm = ({recipe, onSave, disabled, onCancel}) =>{
  
  const onSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entries = [...formData.entries()];

    const recipe = entries.reduce((acc, entry) => {
      const[k, v] = entry;
      acc[k] = v;
      return acc;
    }, {});
    return onSave(recipe);
  }

  return (
    <form onSubmit={onSubmit}>
      <div className="formContainer">
      <label htmlFor="title">Recipe title</label>
      <input id="title" name="title" defaultValue={recipe ? recipe.title : null}></input>
      <label htmlFor="preparation">Preparation</label>
      <textarea id="preparation" name="preparation">{recipe ? recipe.preparation : null}</textarea>
      <button type="submit" disabled={disabled}>{recipe ? "Update recipe" : "Create recipe"}</button>
      <button onClick={onCancel}>Cancel</button>
      </div>
    </form>
  )
}
export default RecipeForm;