document.addEventListener("DOMContentLoaded", () => {
  const id = document.querySelector("div.id input");
  const pwd1 = document.querySelector("div.pwd1 input");
  const pwd2 = document.querySelector("div.pwd2 input");
  const name = document.querySelector("div.name input");
  const tel = document.querySelector("div.tel input");

  const error_box = document.querySelectorAll("div.error");
  const error_id = document.querySelector("div.error.id");
  const error_pwd1 = document.querySelector("div.error.pwd1");
  const error_pwd2 = document.querySelector("div.error.pwd2");
  const error_name = document.querySelector("div.error.name");
  const error_tel = document.querySelector("div.error.tel");

  const join_btn = document.querySelector("button.joinBtn");
  const join_form = document.querySelector("form.joinForm");

  const err_clear = () => {
    for (let box of error_box) {
      box.classList.remove("on");
    }
  };

  const joinCheck = () => {
    err_clear();
    if (!id.value) {
      error_id.innerText = "ID를 입력하세요";
      error_id.classList.add("on");
      return false;
    }

    if (!pwd1.value) {
      error_pwd1.innerText = "패스워드를 입력하세요";
      error_pwd1.classList.add("on");
      return false;
    }
    if (!pwd2.value) {
      error_pwd2.innerText = "패스워드 확인란을 입력하세요";
      error_pwd2.classList.add("on");
      return false;
    }

    if (!(pwd1.value === pwd2.value)) {
      error_pwd1.innerText = "패스워드가 일치하지 않습니다.";
      error_pwd1.classList.add("on");
      pwd1.focus();
      error_pwd2.innerText = "패스워드가 일치하지 않습니다.";
      error_pwd2.classList.add("on");
      return false;
    }

    if (!name.value) {
      error_name.innerText = "이름을 입력하세요";
      error_name.classList.add("on");
      return false;
    }
    if (!tel.value) {
      error_tel.innerText = "전화번호를 입력하세요";
      error_tel.classList.add("on");
      return false;
    }

    join_form.submit();
  };
  join_btn?.addEventListener("click", joinCheck);
});
