document.addEventListener("DOMContentLoaded", ()=> {
    const menuBar = document.querySelector("ul.nav");

    const navClickHandler = (e) => {
        const target = e.target;
        let location = "/";
        if(target.tagName === "LI") {
            location = target.className;
        }
        document.location.href = `/${location}`;
    }

    menuBar?.addEventListener("click", navClickHandler);
})