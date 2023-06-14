
const IngredientForm = ({ writeIngredient, amount, setAmount, unit, setUnit, ingredientName, setIngredientName }) => {
    const pushIngredient = (e) => {
        if (!amount || !unit || !ingredientName) return;
        writeIngredient(amount, unit, ingredientName);
        setAmount(0);
        setUnit("");
        setIngredientName("");
    };
    return (
        <tr>
            <td><input className="ingredient-amount-input" type="Number" onChange={e => setAmount(e.target.value)} value={amount}></input></td>
            <td><input className="ingredient-unit-input" type="text" onChange={e => setUnit(e.target.value)} value={unit}></input></td>
            <td><input className="ingredient-name-input" type="text" onChange={e => setIngredientName(e.target.value)} value={ingredientName}></input></td>
            <td><button type="button" className="row-button" onClick={e => pushIngredient(e)}>Add Ingredient</button></td>
        </tr>
    );
}

export default IngredientForm;