import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from "../App";
import ShopMain from "../comps/ShopMain";
import UserJoin from "../comps/users/UserJoin";
import UserLogin from "../comps/users/UserLogin";
import MyPage from "../comps/users/MyPage";
import ProductListPage from "../comps/product/ProductListPage";
import AddProduct from "../comps/product/AddProduct";
import ProductDetail from "../comps/product/ProductDetail";

const MainRouter = () => {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <App />,
      children: [
        { path: "", element: <ShopMain /> },
        { path: "/join", element: <UserJoin /> },
        { path: "login", element: <UserLogin /> },
        { path: "/mypage", element: <MyPage /> },
        { path: "/product/:c_seq", element: <ProductListPage /> },
        { path: "/addItem", element: <AddProduct /> },
        { path: `/product/item/:p_seq`, element: <ProductDetail /> },
      ],
    },
  ]);
  return <RouterProvider router={router} />;
};

export default MainRouter;
