import { useEffect, useState } from "react";
import Recipe from "../Components/Recipe";

const fetchRecipes = () => {
  return fetch(`/recipes/all`).then((res) => res.json());
};

const RecipeList = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetchRecipes().then((recipes) => {
      setData(recipes);
    });
  }, []);

  if(data === null) {
    return (
      <div>Loading</div>
    )
  }
  return (
    <>
    {data.map((recipe)=> <Recipe recipe={recipe} key={recipe.id}/>)}
    </>
  )
};

export default RecipeList;
