document.addEventListener("DOMContentLoaded", () => {
  const menu = document.querySelector("section");
  const menuOnOffButton = document.querySelector("button.onOff");
  const menuList = document.querySelector("div.left-wrapper");

  const menuCLickHandler = (e) => {
    const target = e.target;
    if (target.tagName === "NAV") {
      const targetClassName = target.className;
      let URL = `${rootPath}/` + targetClassName;

      if (targetClassName === "home") {
        URL = `${rootPath}`;
      }
      document.location.href = URL;
    }
  };

  menu?.addEventListener("click", menuCLickHandler);

  const menuOnOffHandler = () => {
    if (menuList.style.display === "block") {
      menuList.style.display = "none";
    } else {
      menuList.style.display = "block";
    }
  };

  menuOnOffButton?.addEventListener("click", menuOnOffHandler);
});
