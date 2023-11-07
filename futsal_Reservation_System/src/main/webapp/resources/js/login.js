document.addEventListener("DOMContentLoaded", () => {
  const loginForm = document.querySelector("form.main.login");
  const loginBtn = document.querySelector("div.login.button button");

  const loginId = document.querySelector("div.login.id input");
  const loginPwd = document.querySelector("div.login.pwd input");

  const loginError = document.querySelector("span.login.check");

  const loginCheck = () => {
    if (!loginId.value) {
      loginError.innerHTML = "아이디를 입력하세요";
      return false;
    }
    if (!loginPwd.value) {
      loginError.innerHTML = "패스워드를 입력하세요";
      return false;
    }

    loginForm.submit();
  };

  loginBtn?.addEventListener("click", loginCheck);
});
