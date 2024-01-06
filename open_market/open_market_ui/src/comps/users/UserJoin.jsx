import { useRef, useState } from "react";

import { useNavigate } from "react-router-dom";

const UserJoin = () => {
  const [joinUser, setJoinUser] = useState({});
  const navigate = useNavigate();

  const inputChangeHandler = (e) => {
    const { name, value } = e.target;
    setJoinUser({ ...joinUser, [name]: value });
    // console.log(name, value);
  };

  const joinBtnClickHandler = async () => {
    if (
      !(
        joinUser.u_id ||
        joinUser.u_password ||
        joinUser.u_name ||
        joinUser.u_nickname ||
        joinUser.u_phone
      )
    ) {
      alert("입력 폼을 모두 입력해주세요");
    } else {
      const res = await fetch("/join", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(joinUser),
      });
      if (res.status === 200) {
        const data = await res.json();
        console.log(data);
        alert("회원가입 완료!");
        navigate("/");
      } else {
        alert("회원가입 실패");
      }
    }
  };

  const idValidateBtn = async () => {
    if (!joinUser.u_id) {
      alert("ID를 입력하세요");
    } else {
      const res = await fetch("/idValidate", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(joinUser),
      });
      if (res.status === 200) {
        const data = await res.text();
        alert(data);
      } else {
        alert("다시 시도하세요");
      }
    }
  };

  const pwdSameValidate = (e) => {
    const value = e.target.value;
    if (!joinUser.u_password) {
      alert("패스워드를 먼저 입력해주세요");
      pwd1Focus.current.focus();
    } else if (joinUser.u_password === value) {
      alert("패스워드가 일치합니다.");
    }
  };

  const pwd1Focus = useRef(null);

  return (
    <div className="join_form">
      <h1 className="join_title">회원가입</h1>
      <div className="join_div id">
        <label>아이디</label>
        <input
          name="u_id"
          placeholder="아이디"
          onChange={inputChangeHandler}
          autoFocus
        />
        <button onClick={idValidateBtn}>중복 확인</button>
      </div>

      <div className="join_div">
        <label>패스워드</label>
        <input
          name="u_password"
          placeholder="비밀번호"
          type="password"
          onChange={inputChangeHandler}
          ref={pwd1Focus}
        />
      </div>
      <div className="join_div">
        <label>패스워드 확인</label>
        <input
          name="u_password2"
          type="password"
          placeholder="비밀번호 확인"
          onBlur={pwdSameValidate}
        />
      </div>
      <div className="join_div">
        <label>이름</label>
        <input name="u_name" placeholder="이름" onChange={inputChangeHandler} />
      </div>
      <div className="join_div">
        <label>닉네임</label>
        <input
          name="u_nickname"
          placeholder="닉네임"
          onChange={inputChangeHandler}
        />
      </div>
      <div className="join_div">
        <label>전화번호</label>
        <input
          name="u_phone"
          placeholder="전화번호"
          onChange={inputChangeHandler}
        />
      </div>
      <div className="join_div btn">
        <button onClick={joinBtnClickHandler}>회원가입</button>
      </div>
    </div>
  );
};

export default UserJoin;
