import { Outlet  } from "react-router-dom";
import Header from "../Components/Header";
import { useState, createContext } from "react";

export const TokenContext = createContext();

const Layout = () => {
  const [token, setToken] = useState("");

  return (
    <div className="Layout">
      <TokenContext.Provider value={{token, setToken}}>
        <Header />
        <Outlet />
      </TokenContext.Provider>
    </div>
  );
};

export default Layout;
