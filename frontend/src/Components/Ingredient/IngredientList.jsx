import { useEffect, useState } from "react";
import IngredientPart from "./IngredientPart";
import IngredientForm from "./IngredientForm";

const IngredientList = ( { addIngredient }) => {
    const [ingredients, setIngredients] = useState([]);
    const [amount, setAmount] = useState(0);
    const [unit, setUnit] = useState("");
    const [ingredientName, setIngredientName] = useState("");

    function writeIngredient(newAmount, newUnit, newName) {
        const newIngredient = [...ingredients, { amount: Number(newAmount), unit: newUnit, ingredientName: newName }];
        setIngredients(newIngredient);
    };

    const deleteIngredient = (ingredient) => {
        const newIngredients = [...ingredients];
        const index = newIngredients.indexOf(ingredient);
        newIngredients.splice(index, 1);
        setIngredients(newIngredients);
    };

    const modifyIngredient = (ingredient) => {
        deleteIngredient(ingredient);
        setAmount(ingredient.amount);
        setUnit(ingredient.unit);
        setIngredientName(ingredient.ingredientName);
        console.log("modify" + ingredient);
    };
    
    useEffect(() => {
        addIngredient(ingredients);
    },[ingredients, addIngredient])

    return (
        <div>
            <div>
                <label>Ingredients</label>
                <table>
                    <thead>
                        <tr>
                            <th>Amount</th>
                            <th>Unit</th>
                            <th>Igredient</th>
                        </tr>
                    </thead>
                    <tbody>
                        {ingredients.map((ingredient, index) => (
                                <IngredientPart 
                                    key={index}
                                    index={index}
                                    ingredient={ingredient}
                                    deleteIngredient={(ingredient) => deleteIngredient(ingredient)}  //TODO
                                    modifyIngredient={(ingredient) => modifyIngredient(ingredient)}  //TODO
                                />
                            ))}
                    </tbody>
                </table>
                <IngredientForm writeIngredient={writeIngredient}
                   amount={amount} setAmount={setAmount} 
                   unit={unit} setUnit={setUnit}
                   ingredientName={ingredientName} setIngredientName={setIngredientName}/>
            </div>
        </div>
    );
}

export default IngredientList;