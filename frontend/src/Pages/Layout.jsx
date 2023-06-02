import { Outlet } from "react-router-dom";
import Header from "../Components/Header";

const Layout = () => {
  return (
    <div className="Layout">
      <Header />
      <Outlet />
    </div>
  );
};

export default Layout;
