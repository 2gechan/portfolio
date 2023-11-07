document.addEventListener("DOMContentLoaded", ()=> {
    const board_write_btn = document.querySelector("button.board.button.write");
    const category_list = document.querySelector("ul.board.category");
    const board_table = document.querySelector("table.board.list");
    const returnhome_btn = document.querySelector("button.returnhome");
    const update_btn = document.querySelector("button.update");
    const delete_btn = document.querySelector("button.delete");
    const page_container = document.querySelector("div.pagination");

    const pageClick = (e) => {
        const target = e.target;

        if (target.tagName === "SPAN") {
            const pageNum = target.className;
            // alert(pageNum);
            document.location.href = `/board?page=${pageNum}`;
        }
    }

    page_container?.addEventListener("click", pageClick);

    returnhome_btn?.addEventListener("click", ()=> {
        document.location.href="/board"
    })

    delete_btn?.addEventListener("click", (e)=> {
        if (confirm("정말 삭제하시겠습니까 ?")) {
            const target = e.target;
            const id = target.dataset.id;
            document.location.href = `/board/delete?seq=${id}`;
        }
    })

    update_btn?.addEventListener("click", (e)=> {
        const target = e.target;
        const id = target.dataset.id;
        document.location.href = `/board/update?seq=${id}`;
    })

    board_write_btn?.addEventListener("click", ()=> {
        document.location.href = "/board/write";
    })

    const categoryClick = (e) => {
        const target = e.target;
        const targetClassName = target.className;
        // alert(targetClassName);
        if (target.tagName === "LI") {
            document.location.href = `/board?ca=${targetClassName}`;
        }
    }
    category_list?.addEventListener("click", categoryClick);

    const trClickHandler = (e) => {
        const td = e.target;
        if (td.tagName === "TD") {
            const tr = td.closest("TR");
            // alert(tr.className);
            const seq = tr.className;
            document.location.href = `board/detail?seq=${seq}`;
        }
    }
    board_table?.addEventListener("click", trClickHandler);
})