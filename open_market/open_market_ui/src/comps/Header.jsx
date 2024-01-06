import { useRef, useState } from "react";
import { NavLink } from "react-router-dom";

const Header = () => {
  const [visible, setVisible] = useState(false);
  const cartInfo = useRef(null);
  const cartMouseOver = () => {
    setVisible(true);
  };
  const cartMouseLeave = () => {
    setVisible(false);
  };
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
        <NavLink
          className="cart"
          onMouseOver={cartMouseOver}
          onMouseLeave={cartMouseLeave}
        >
          <li>CART</li>
          {visible ? (
            <div ref={cartInfo} className="cart_box">
              <span>카트</span>
            </div>
          ) : (
            <div>카트가림</div>
          )}
        </NavLink>
        <div>
          <input placeholder="검색어를 입력하세요" />
          <button>검색</button>
        </div>
      </ul>
    </>
  );
};

export default Header;
