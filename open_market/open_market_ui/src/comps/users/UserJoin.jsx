import { useState } from "react";

import "../../css/UserJoin.css";

const UserJoin = () => {
  const [joinUser, setJoinUser] = useState({});

  const inputChangeHandler = (e) => {
    const { name, value } = e.target;
    setJoinUser({ ...joinUser, [name]: value });
    console.log(name, value);
  };

  const joinBtnClickHandler = () => {};

  return (
    <div className="join_form">
      <div>
        <label>아이디</label>
        <input name="u_id" placeholder="아이디" onChange={inputChangeHandler} />
      </div>
      <div>
        <label>패스워드</label>
        <input
          name="u_password"
          placeholder="비밀번호"
          onChange={inputChangeHandler}
        />
      </div>
      <div>
        <label>이름</label>
        <input name="u_name" placeholder="이름" onChange={inputChangeHandler} />
      </div>
      <div>
        <label>닉네임</label>
        <input
          name="u_nickname"
          placeholder="닉네임"
          onChange={inputChangeHandler}
        />
      </div>
      <div>
        <label>전화번호</label>
        <input
          name="u_phone"
          placeholder="전화번호"
          onChange={inputChangeHandler}
        />
      </div>
      <div>
        <button onClick={joinBtnClickHandler}>회원가입</button>
      </div>
    </div>
  );
};

export default UserJoin;
