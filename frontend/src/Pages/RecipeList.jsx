import { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import RecipeCard from "../Components/Recipe/RecipeCard";

async function fetchRecipes() {
  return await fetch(`/recipes/all`).then((res) => res.json());
};

const fetchRecipesWithParams = (query) => {
  return fetch(`/recipes/search${query}`).then((res) => res.json());

}

const RecipeList = () => {
  const [data, setData] = useState(null);
  const location = useLocation();
  const search = location.search;


  useEffect(() => {
    if (search) {
      fetchRecipesWithParams(search).then((recipes) => {
        setData(recipes);
      })
    } else {
      fetchRecipes().then((recipes) => {
        setData(recipes);
      });
    }

  }, [search]);

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
                <RecipeCard recipe={recipe} />
              </Link>
            </div>
          </div>
        )}
      </div>
    </main>
  )
};

export default RecipeList;
