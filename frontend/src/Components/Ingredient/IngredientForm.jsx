import { useState } from "react";

const IngredientForm = ( addIngredient ) => {
    const [amount, setAmount] = useState(0);
    const [unit, setUnit] = useState("");
    const [ingredientName, setIngredientName] = useState("");
    const handleSubmit = e => {
        e.preventDeafult();
        if(!amount || !unit || !ingredientName) return;
        addIngredient(amount, unit, ingredientName);
        setAmount(0);
        setUnit("");
        setIngredientName("");
    };
    return (
    <form onSubmit={handleSubmit}>
        <input type="Number" className="" onChange={e => setAmount(e.target.value)} value={amount}></input>
        <input type="text" onChange={e => setUnit(e.target.value)} value={unit}></input>
        <input type="text" onChange={e => setIngredientName(e.target.value)} value={ingredientName}></input>
        <button type="submit">Add Ingredient</button>
    </form>
    );
}

export default IngredientForm;