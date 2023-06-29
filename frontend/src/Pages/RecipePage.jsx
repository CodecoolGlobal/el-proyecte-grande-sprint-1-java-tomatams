import React from "react";
import { useEffect, useState, useContext } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Recipe from "../Components/Recipe/Recipe";
import { TokenContext } from "./Layout"; // always copy where token is used


async function fetchRecipe(id) {
  return await fetch(`/recipes/${id}`)
    .then((res) => res.json()
    )
}

const deleteRecipe = (id, token) => {
  return fetch(`/recipes/delete/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
      "Authorization": token ? token : ""
    },
  });
}

const RecipePage = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [recipe, setRecipe] = useState(null);
  const [loading, setLoading] = useState(true);
  const { token } = useContext(TokenContext); // always copy where token is used


  const handleDelete = (id) => {
    deleteRecipe(id, token)
      .then(() => {
        navigate("/")
      })
      .catch((error) => {
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