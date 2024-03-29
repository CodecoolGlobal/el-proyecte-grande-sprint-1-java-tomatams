import { Outlet } from "react-router-dom";
import Header from "../Components/Header";
import { useEffect, useState, createContext } from "react";

export const TokenContext = createContext();

const Layout = () => {
  const [token, setToken] = useState("");

  useEffect(() => {
    setToken(localStorage.getItem("token"))
    console.log("TOKEN LAYOUT ", token);
  }, [token])

  return (
    <div className="Layout">
      <TokenContext.Provider value={{ token, setToken }}>
        <Header />
        <Outlet />
      </TokenContext.Provider>
    </div>
  );
};

export default Layout;
