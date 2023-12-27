document.addEventListener("DOMContentLoaded", ()=> {
    const menuBar = document.querySelector("nav.menu");

    const menu_Click_Handler = (e) => {
        const target = e.target;
        if (target.tagName === 'SPAN') {
            const className = target.className;
            document.location.href = `/${className}`;
            alert(className);
        }
    }
    menuBar.addEventListener("click", menu_Click_Handler);
})