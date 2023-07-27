import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Layout from './Pages/Layout';
import RecipeList from './Pages/RecipeList';
import RecipeCreator from './Pages/RecipeCreator';
import RecipePage from './Pages/RecipePage';
import UserCreator from './Pages/UserCreator';
import LoginPage from './Pages/LoginPage';
import ProfilePage from './Pages/ProfilePage';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <RecipeList />
      },
      {
        path: "/create",
        element: <RecipeCreator />
      },
      {
        path: "/recipes/:id",
        element: <RecipePage />
      },
      {
        path: "/search",
        element: <RecipeList />
      },
      {
        path: "/register",
        element: <UserCreator />
      },
      {
        path: "/login",
        element: <LoginPage />
      },
      {
        path: "/profile",
        element: <ProfilePage />
      }
    ]
  }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
