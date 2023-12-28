import { NavLink } from "react-router-dom";

const Header = () => {
  return (
    <>
      <h1 className="main_title">
        <NavLink to="/">Open Market</NavLink>
      </h1>
      <ul className="main_menu_bar">
        <NavLink to="/">
          <li>HOME</li>
        </NavLink>
        <NavLink to="/join">
          <li>JOIN</li>
        </NavLink>
        <NavLink to="/login">
          <li>LOGIN</li>
        </NavLink>
        <NavLink to="/mypage">
          <li>MYPAGE</li>
        </NavLink>
      </ul>
    </>
  );
};

export default Header;
