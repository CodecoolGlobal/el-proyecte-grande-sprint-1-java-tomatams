import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Recipe from "../Components/Recipe";

async function fetchRecipe (id) {
  return await fetch(`/recipes/${id}`)
    .then((res) => res.json()
    )
}

const deleteRecipe = (id) => {
  return fetch(`/recipes/delete/${id}`, {method: "DELETE"}).then((res) => res.json());
}

const RecipePage = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [recipe, setRecipe] = useState(null);
  const [loading, setLoading] = useState(true);

  const handleDelete = (id) => {
    console.log(id);
    deleteRecipe(id).catch((error) => {
      console.log(error);
    });
  }


  useEffect(() => {
     fetchRecipe(id)
      .then((recipe) => {
        setRecipe(recipe);
        setLoading(false);
      })
      .catch((err) => {
        throw err;
      })
  }, [id]);

  if (loading) {
    return <div>Loading...</div>
  };

  return (
    <main>
      <div className="recipe-container">
        <Recipe
          recipe={recipe} onDelete={handleDelete}
        />
      </div>
    </main>
  )
};

export default RecipePage;