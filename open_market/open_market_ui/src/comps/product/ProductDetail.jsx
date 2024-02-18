import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";

const ProductDetail = () => {
  const { p_seq } = useParams();
  const [pInfo, setPInfo] = useState({});
  const imagePath = `http://localhost:8080/static/${pInfo.p_main_image_name}`;
  const [images, setImages] = useState([]);

  useEffect(() => {
    const p_infoRetv = async () => {
      const res = await fetch(`detail?p_seq=${p_seq}`, {
        method: "GET",
      });
      const data = await res.json();
      // console.log(data);
      setPInfo(data);
    };
    const subImagesListRetv = async () => {
      const res = await fetch(`detailImage?p_seq=${p_seq}`, {
        method: "GET",
      });
      const data = await res.json();
      // console.log(data);
      setImages([...data]);
    };
    p_infoRetv();
    subImagesListRetv();
  }, []);

  const subImageList = images.map((item) => {
    const imagePath = `http://localhost:8080/static/${item.i_image_name}`;
    console.log(item.i_image_name);
    return (
      <img src={imagePath} alt="서브이미지" width="100px" height="100px"></img>
    );
  });

  const likeBtnClick = () => {
    setPInfo({ ...pInfo, [pInfo.p_like]: pInfo.p_like + 1 });
    console.log(pInfo.p_like + 1);
  };

  return (
    <>
      <div className="product_detail_top">
        <div>
          <img src={imagePath} alt="메인이미지" width="400px" height="400px" />
        </div>
        <div>
          <label>상품명 : </label>
          <span>{pInfo.p_name}</span>
        </div>
        <div>
          <label>상품가격 : </label>
          <span>{pInfo.p_price}</span>
        </div>
        <div>
          <label>상품설명 : </label>
          <span>{pInfo.p_text}</span>
        </div>
        <div>
          <label>찜개수 : </label>
          <span>{pInfo.p_like}</span>
        </div>
        <div>
          <button>구매하기</button>
          <button onClick={likeBtnClick} type="none">
            찜하기
          </button>
          <button>장바구니 담기</button>
        </div>
      </div>
      <div className="product_detail_bottom">
        <div>{subImageList}</div>
      </div>
    </>
  );
};
export default ProductDetail;
