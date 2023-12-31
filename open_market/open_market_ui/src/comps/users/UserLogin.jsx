import { useState } from "react";
import { useNavigate } from "react-router-dom";

const UserLogin = () => {
  const [loginUser, setLoginUser] = useState({});
  const navigate = useNavigate();

  const loginInputChangeHandler = (e) => {
    const { name, value } = e.target;
    setLoginUser({ ...loginUser, [name]: value });
    console.log(name, value);
  };

  const loginBtnClickHandler = async () => {
    if (loginUser.u_id && loginUser.u_password) {
      const res = await fetch("/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(loginUser),
      });
      const text = await res.text();
      if (text === "OK") {
        navigate("/");
      } else {
        alert("로그인 정보를 확인하세요");
      }
    } else {
      alert("입력창을 입력하세요");
    }
  };
  return (
    <div className="login_form">
      <h1 className="login_title">로그인</h1>
      <div className="login_div">
        <label htmlFor="">아이디</label>
        <input
          placeholder="아이디를 입력하세요"
          name="u_id"
          onChange={loginInputChangeHandler}
        />
      </div>
      <div className="login_div">
        <label htmlFor="">비밀번호</label>
        <input
          placeholder="비밀번호를 입력하세요"
          name="u_password"
          type="password"
          onChange={loginInputChangeHandler}
        />
      </div>
      <div className="login_div btn">
        <button onClick={loginBtnClickHandler}>로그인</button>
      </div>
    </div>
  );
};

export default UserLogin;
