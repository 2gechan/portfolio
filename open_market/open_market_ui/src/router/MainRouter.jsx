import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from "../App";
import ShopMain from "../comps/ShopMain";
import UserJoin from "../comps/users/UserJoin";

const MainRouter = () => {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <App />,
      children: [
        { path: "", element: <ShopMain /> },
        { path: "/join", element: <UserJoin /> },
      ],
    },
  ]);
  return <RouterProvider router={router} />;
};

export default MainRouter;
