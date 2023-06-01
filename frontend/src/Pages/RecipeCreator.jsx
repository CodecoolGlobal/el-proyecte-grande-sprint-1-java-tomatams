import { useState} from "react";
import { useNavigate} from "react-router-dom";
import RecipeForm from "../Components/RecipeForm";

const createRecipe = (recipe) => {
  console.log(recipe);
  return fetch("/recipes/add", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(recipe)
  }).then((res) => res.json());
};


const RecipeCreator = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const handleCreateRecipe = (recipe) => {
    setLoading(true);
    createRecipe(recipe)
    .then(() => {
      navigate("/");
    })
    .catch((err) => {
      throw(err);
    })
    .finally(()=> {
      setLoading(false);
    })
  };

  return (
    <RecipeForm
    onCancel={()=> navigate("/")}
    disabled={loading}
    onSave= {handleCreateRecipe}/>
  )
}

export default RecipeCreator;