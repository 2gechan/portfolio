import { useEffect, useRef, useState } from "react";
import { NavLink } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { logout } from "../redux/UserReducer";

const Header = () => {
  const [visible, setVisible] = useState(false);

  const loginUser = useSelector((state) => state.user.user);
  const dispatch = useDispatch();

  const cartMouseOver = () => {
    setVisible(true);
  };
  const cartMouseLeave = () => {
    setVisible(false);
  };

  const loginSessionRmv = async () => {
    await fetch("/logout", {
      method: "GET",
    });
  };

  const logoutEvent = () => {
    loginSessionRmv();
    dispatch(logout());
    console.log(loginUser.u_id);
  };

  useEffect(() => {
    const userInfoUpdate = () => {
      console.log("로그인 아이디 : ", loginUser.u_id);
      console.log("로그인 비밀번호 : ", loginUser.u_password);
      console.log("로그인 이름   : ", loginUser.u_name);
    };
    userInfoUpdate();
  }, [loginUser]);

  return (
    <>
      <h1 className="main_title">
        <NavLink to="/">Open Market</NavLink>
      </h1>
      <ul className="main_menu_bar">
        <NavLink to="/">
          <li>HOME</li>
        </NavLink>
        {loginUser.u_id ? (
          <>
            <NavLink onClick={logoutEvent}>
              <li>LOGOUT</li>
            </NavLink>
            <NavLink to="/mypage">
              <li>MYPAGE</li>
            </NavLink>
          </>
        ) : (
          <>
            <NavLink to="/join">
              <li>JOIN</li>
            </NavLink>
            <NavLink to="/login">
              <li>LOGIN</li>
            </NavLink>
          </>
        )}

        <NavLink to="/test">
          <li>TEST-PAGE</li>
        </NavLink>
        <NavLink
          className="cart"
          onMouseOver={cartMouseOver}
          onMouseLeave={cartMouseLeave}
        >
          <li>CART</li>
          {visible ? (
            <div className="cart_box">
              <span>카트</span>
            </div>
          ) : (
            <></>
          )}
        </NavLink>

        <div className="search_form">
          <input placeholder="검색어를 입력하세요" />
          <button>검색</button>
        </div>
      </ul>
    </>
  );
};

export default Header;
