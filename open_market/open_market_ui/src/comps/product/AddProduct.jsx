import { useRef, useState } from "react";

const AddProduct = () => {
  const imgRef = useRef(null);
  const imgsRef = useRef(null);
  const [product, setProduct] = useState({});

  const form_transfer = () => {
    const formData = new FormData();
  };

  const inputChangeHandler = (e) => {
    const { name, value } = e.target;
    setProduct({ ...product, [name]: value });
  };

  return (
    <div className="add_wrapper">
      <h1>아이템 추가</h1>
      <div className="add_form">
        <div className="add_form_div">
          <label>카테고리</label>
          <select name="c_name">
            <option selected>===선택하세요===</option>
            <option value="electronic">전자기기</option>
            <option value="cloth">의류</option>
            <option value="etc">기타</option>
          </select>
        </div>
        <div className="add_form_div">
          <label>상품명</label>
          <input placeholder="상품명을 입력하세요" name="p_name" />
        </div>
        <div className="add_form_div">
          <label>설명</label>
          <textarea
            placeholder="내용을 입력하세요"
            name="p_text"
            rows="15"
            cols="50"
          />
        </div>
        <div className="add_form_div">
          <label>가격</label>
          <input placeholder="" type="number" />
        </div>
        <div className="add_form_div">
          <label>대표이미지</label>
          <input type="file" ref={imgRef} accept="image/*" />
        </div>
        <div className="add_form_div">
          <label>상세이미지</label>
          <input
            type="file"
            ref={imgsRef}
            accept="image/*"
            multiple="multiple"
          />
        </div>
        <div className="add_form_div">
          <button>등록</button>
        </div>
      </div>
    </div>
  );
};

export default AddProduct;
