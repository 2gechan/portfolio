import { useState } from "react";

import "../../css/UserJoin.css";

const UserJoin = () => {
  const [joinUser, setJoinUser] = useState({});

  const inputChangeHandler = (e) => {
    const { name, value } = e.target;
    setJoinUser({ ...joinUser, [name]: value });
    console.log(name, value);
  };

  const joinBtnClickHandler = async () => {
    const res = await fetch("/join", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(joinUser),
    });
    if (res.status === 200) {
      const data = await res.text();
      console.log(data);
    } else {
      alert("회원가입 실패");
    }
  };

  const idValidateBtn = async () => {
    if (joinUser.u_id === "") {
      alert("id를 입력하세요");
    } else {
      const res = await fetch("/idValidate", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: joinUser.u_id,
      });
      if (res.status === 200) {
        const data = await res.text();
        alert(data);
      } else {
        alert("다시 시도하세요");
      }
    }
  };

  return (
    <div className="join_form">
      <div>
        <label>아이디</label>
        <input name="u_id" placeholder="아이디" onChange={inputChangeHandler} />
        <button onClick={idValidateBtn}>중복 확인</button>
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
