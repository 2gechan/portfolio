document.addEventListener("DOMContentLoaded", () => {
  const regBtn = document.querySelector("button.reg.button");
  const updateBtn = document.querySelector("button.update.button");
  const deleteBtn = document.querySelector("button.delete.button");
  const infoUpdateBtn = document.querySelector("button.updateBtn");
  const updateBackBtn = document.querySelector("button.update.backBtn");
  const updateForm = document.querySelector("form.user.updateForm");

  const regEventHandler = (e) => {
    const target = e.target;
    const id = target.dataset.id;
    document.location.href = `${rootPath}/reg?id=${id}`;
  };
  regBtn?.addEventListener("click", regEventHandler);

  const updateEventHandler = (e) => {
    const target = e.target;
    const id = target.dataset.id;
    document.location.href = `${rootPath}/update?id=${id}`;
  };
  updateBtn?.addEventListener("click", updateEventHandler);

  const deleteEventHandler = (e) => {
    const target = e.target;
    const id = target.dataset.id;
    document.location.href = `${rootPath}/delete?id=${id}`;
  };
  deleteBtn?.addEventListener("click", deleteEventHandler);

  updateBackBtn?.addEventListener("click", () => {
    document.location.href = "/mypage";
  });

  infoUpdateBtn?.addEventListener("click", () => {
    updateForm.submit();
  });
});
