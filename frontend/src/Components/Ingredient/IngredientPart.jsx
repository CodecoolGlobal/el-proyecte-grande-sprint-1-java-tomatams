const IngredientPart  = (onClick) => {
    return (
    <div>
        <label>Ingredients</label>
        <button onClick={() => onClick}>Add New Ingredient</button>
    </div>);
}

export default IngredientPart;
