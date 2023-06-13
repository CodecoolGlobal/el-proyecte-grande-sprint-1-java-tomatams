const IngredientPart  = ( { ingredient } ) => {
    return (
        <tr>
            <td>{ingredient.amount}</td>
            <td>{ingredient.unit}</td>
            <td>{ingredient.ingredientName}</td>
        </tr>
    );
}

export default IngredientPart;
