import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { NavLink, useNavigate } from "react-router-dom";

const ProductListPage = () => {
  const [list, setList] = useState([]);
  const [ctgy, setCtgy] = useState([]);
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
    const initCtgyList = async () => {
      const res = await fetch("/ctgyList");
      const data = await res.json();
      setCtgy([...data]);
    };
    initCtgyList();
    const initProdList = async () => {
      const res = await fetch("/prodList");
      const data = await res.json();
      setList([...data]);
    };
    initProdList();
  }, []);

  const productList = list.map((item) => {
    // 이미지 파일 따로 불러와야할듯
    // 아니면 메인 이미지 이름만 상품정보에 넣어놓고
    // 디테일 페이지로 넘어갔을시 이미지 db에서 상품 seq를 통해서 다 불러올까?
    const imagePath = `http://localhost:8080/static/${item.p_main_image}`;
    const detailLink = `/product/${item.p_seq}`;
    return (
      // datailLink 에 대해서 생각좀 더 해봐야함
      <NavLink to={detailLink}>
        <div key={item.p_seq} className="p_Info">
          {/* <img src={imagePath} alt="상품" width="100px" height="100px" /> */}
          <span>상품 이름 : {item.p_name}</span>
          <span> 가격 : {item.p_price}</span>
        </div>
      </NavLink>
    );
  });

  const categoryList = ctgy.map((item) => {
    return (
      <div key={item.c_seq} className="c_div">
        <strong className="c_name">{item.c_name}</strong>
        <span className="c_count"> 상품 개수 : {item.c_pcount}</span>
      </div>
    );
  });

  return (
    <div className="product_wrapper">
      <div className="product_category">
        <h1>카테고리</h1>
        {categoryList}
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
