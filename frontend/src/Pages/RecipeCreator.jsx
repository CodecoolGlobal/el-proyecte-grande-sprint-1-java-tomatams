import { useState, useEffect, useContext } from "react";
import { useNavigate } from "react-router-dom";
import RecipeForm from "../Components/Recipe/RecipeForm";
import { TokenContext } from "./Layout"; // always copy where token is used


const createRecipe = (recipe, token) => {
  console.log(recipe);
  return fetch("/recipes/add", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": token ? token : ""
    },
    body: JSON.stringify(recipe)
  }).then((res) => res.json());
};


const RecipeCreator = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const { token } = useContext(TokenContext); // always copy where token is used


  const handleCreateRecipe = (recipe) => {
    setLoading(true);
    createRecipe(recipe, token)
      .then(() => {
        navigate("/");
      })
      .catch((err) => {
        throw (err);
      })
      .finally(() => {
        setLoading(false);
      })
  };

  return (
    <RecipeForm
      onCancel={() => navigate("/")}
      disabled={loading}
      onSave={handleCreateRecipe} />
  )
}

export default RecipeCreator;