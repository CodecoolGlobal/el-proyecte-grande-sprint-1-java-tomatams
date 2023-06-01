import { useEffect, useState } from "react";
import Recipe from "../Components/Recipe";
import { Link } from "react-router-dom";

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

  if (data === null) {
    return (
      <div>Loading</div>
    )
  }
  return (
    <main>
      <div className="main-container">
        {data.map((recipe) =>
          <div className="recipe-box" key={recipe.id} >
            <div className="recipe-content">
              <Link to={`/recipes/${recipe.id}`} style={{ textDecoration: 'none' }}>
                <Recipe recipe={recipe} />
              </Link>
            </div>
          </div>
        )}
      </div>
    </main>
  )
};

export default RecipeList;
