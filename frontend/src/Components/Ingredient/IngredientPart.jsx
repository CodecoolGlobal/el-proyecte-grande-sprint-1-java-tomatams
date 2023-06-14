const IngredientPart = ({ ingredient, deleteIngredient, modifyIngredient }) => {
    return (
        <tr>
            <td>{ingredient.amount}</td>
            <td>{ingredient.unit}</td>
            <td>{ingredient.ingredientName}</td>
            <td>
                <button type="button" className="row-button" onClick={() => deleteIngredient(ingredient)}>delete</button>
                <button type="button" className="row-button" onClick={() => modifyIngredient(ingredient)}>modify</button>
            </td>
        </tr>
    );
}

export default IngredientPart;
