import { useRef, useState } from "react";
import { useSelector } from "react-redux";

const AddProduct = () => {
  const imgRef = useRef(null);
  const imgsRef = useRef(null);
  const [product, setProduct] = useState({});
  const [image, setImage] = useState("");
  const [images, setImages] = useState([]);

  const loginUser = useSelector((state) => state.user.user) || {};

  const form_transfer = async () => {
    const formData = new FormData();

    for (const key in product) {
      formData.append(key, product[key]);
    }
    formData.append("u_id", loginUser.u_id);
    formData.append("p_main_image", imgRef.current.files[0]);

    for (const file of imgsRef.current.files) {
      formData.append("p_images", file);
    }

    // const rtnUserChk = await fetch("/sessionChk", {
    //   method: "POST",
    //   headers: {
    //     "Content-Type": "application/json",
    //   },
    //   body: JSON.stringify(loginUser),
    // });

    const res = await fetch("/uploadItem", {
      method: "POST",
      body: formData,
    });

    console.log(res);

    // const data = await res.json();
    // console.log(data);
  };

  const inputChangeHandler = (e) => {
    const { name, value } = e.target;
    setProduct({ ...product, [name]: value });
  };

  const fileChangeHandler = (e) => {
    const file = e.target.files[0];

    const fileReader = new FileReader();
    fileReader.onload = (fe) => {
      setImage(fe.target.result);
    };
    fileReader.readAsDataURL(file);
    console.log(file.name);
  };

  const filesChangeHandler = (e) => {
    const files = e.target.files;
    console.log(files.length);
    const newImages = [];

    Array.from(files).forEach((file) => {
      const fileReader = new FileReader();
      fileReader.onloadend = (fe) => {
        newImages.push(fe.target.result);
        setImages(newImages);
      };
      fileReader.readAsDataURL(file);
    });
  };

  const subImages = images.map((image, index) => (
    <img key={index} src={image ? image : ""} width="100px" alt="" />
  ));

  return (
    <div className="add_wrapper">
      <h1>아이템 추가</h1>
      <div className="add_form">
        <div className="add_form_div">
          <label>카테고리</label>
          <select name="p_category" onChange={inputChangeHandler}>
            <option defaultValue="x">===선택하세요===</option>
            <option value="electronic">전자기기</option>
            <option value="cloth">의류</option>
            <option value="etc">기타</option>
          </select>
        </div>
        <div className="add_form_div">
          <label>상품명</label>
          <input
            placeholder="상품명을 입력하세요"
            name="p_name"
            onChange={inputChangeHandler}
          />
        </div>
        <div className="add_form_div">
          <label>설명</label>
          <textarea
            placeholder="내용을 입력하세요"
            name="p_text"
            rows="15"
            cols="50"
            onChange={inputChangeHandler}
          />
        </div>
        <div className="add_form_div">
          <label>가격</label>
          <input
            placeholder=""
            type="number"
            name="p_price"
            onChange={inputChangeHandler}
          />
        </div>
        <div className="add_form_div">
          <label>대표이미지</label>
          <input
            type="file"
            ref={imgRef}
            accept="image/*"
            onChange={fileChangeHandler}
          />
        </div>
        <div>
          <img src={image ? image : ""} width="100px" alt="" />
        </div>
        <div className="add_form_div">
          <label>상세이미지</label>
          <input
            type="file"
            ref={imgsRef}
            accept="image/*"
            multiple="multiple"
            onChange={filesChangeHandler}
          />
        </div>
        <div>{subImages}</div>
        <div className="add_form_div">
          <button onClick={form_transfer}>등록</button>
        </div>
      </div>
    </div>
  );
};

export default AddProduct;
