import { useSelector } from "react-redux";
import { NavLink, useNavigate } from "react-router-dom";

const ProductListPage = () => {
  const loginUser = useSelector((state) => state.user.user) || {};
  const navigate = useNavigate();

  const uploadItemPageMove = () => {
    if (!loginUser.u_id) {
      alert("로그인이 필요합니다.");
      navigate("/login");
    } else {
      navigate("/addItem");
    }
  };

  return (
    <div className="product_wrapper">
      <div className="product_category">
        <h1>카테고리</h1>
        <span>카테고리1</span>
        <span>카테고리2</span>
        <span>카테고리3</span>
      </div>
      <div className="product_main">
        <h1>All</h1>
        <div className="product_list">
          <div>상품1</div>
          <div>상품2</div>
          <div>상품3</div>
          <div>상품4</div>
          <div>상품5</div>
        </div>
      </div>
      <button className="product_upload" onClick={uploadItemPageMove}>
        상품 등록
      </button>
    </div>
  );
};

export default ProductListPage;
