import { useEffect, useState } from "react";
import IngredientPart from "./IngredientPart";
import IngredientForm from "./IngredientForm";

const IngredientList = ( { addIngredient }) => {
    const [ingredients, setIngredients] = useState([]);

    function writeIngredient(newAmount, newUnit, newName) {
        const newIngredient = [...ingredients, { amount: Number(newAmount), unit: newUnit, ingredientName: newName }];
        setIngredients(newIngredient);
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
                                    // updateIngredient={updateIngredient}  //TODO
                                    // removeIngredient={removeIngredient}  //TODO
                                />
                            ))}
                    </tbody>
                </table>
                <IngredientForm writeIngredient={writeIngredient}/>
            </div>
        </div>
    );
}

export default IngredientList;