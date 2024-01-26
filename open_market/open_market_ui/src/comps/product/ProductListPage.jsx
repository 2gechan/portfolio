import { NavLink } from "react-router-dom";

const ProductListPage = () => {
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
      <NavLink to="/addItem">
        <button className="product_upload">상품 등록</button>
      </NavLink>
    </div>
  );
};

export default ProductListPage;
