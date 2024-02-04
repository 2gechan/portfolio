import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

const ProductListPage = () => {
  const [list, setList] = useState([]);
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

  useEffect(() => {
    const initProdList = async () => {
      const res = await fetch("/prodList");
      const data = await res.json();
      setList([...data]);
    };
    initProdList();
  }, []);

  const productList = list.map((item) => {
    const imagePath = `http://localhost:8080/static/${item.p_main_image}`;
    const detailLink = `/product/${item.p_seq}`;
    return (
      <div key={item.p_seq} className="p_Info">
        <img src={imagePath} alt="상품" width="100px" height="100px" />
        <span>{item.p_name}</span>
        <span>{item.p_pridce}</span>
      </div>
    );
  });

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
        <div className="product_list">{productList}</div>
      </div>
      <button className="product_upload" onClick={uploadItemPageMove}>
        상품 등록
      </button>
    </div>
  );
};

export default ProductListPage;
