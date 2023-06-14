
const IngredientForm = ( { writeIngredient, amount, setAmount, unit, setUnit, ingredientName, setIngredientName } ) => {
    const pushIngredient = (e) => {
        if(!amount || !unit || !ingredientName) return;
        writeIngredient(amount, unit, ingredientName);
        setAmount(0);
        setUnit("");
        setIngredientName("");
    };
    return (
    <div>
        <input type="Number" onChange={e => setAmount(e.target.value)} value={amount}></input>
        <input type="text" onChange={e => setUnit(e.target.value)} value={unit}></input>
        <input type="text" onChange={e => setIngredientName(e.target.value)} value={ingredientName}></input>
        <button type="button" onClick={e => pushIngredient(e)}>Add Ingredient</button>
    </div>
    );
}

export default IngredientForm;