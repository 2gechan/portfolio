import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import { useSelector } from "react-redux";

const ProductDetail = () => {
  const { p_seq } = useParams();
  const [pInfo, setPInfo] = useState({});
  const imagePath = `http://localhost:8080/static/${pInfo.p_main_image_name}`;
  const [images, setImages] = useState([]);
  const loginUser = useSelector((state) => state.user.user) || {};

  useEffect(() => {
    const p_infoRetv = async () => {
      const res = await fetch(`detail?p_seq=${p_seq}`, {
        method: "GET",
      });
      const data = await res.json();
      setPInfo(data);
    };
    const subImagesListRetv = async () => {
      const res = await fetch(`detailImage?p_seq=${p_seq}`, {
        method: "GET",
      });
      const data = await res.json();
      setImages([...data]);
    };

    p_infoRetv();
    subImagesListRetv();
  }, []);

  const subImageList = images.map((item) => {
    const imagePath = `http://localhost:8080/static/${item.i_image_name}`;
    return (
      <img src={imagePath} alt="서브이미지" width="200px" height="200px"></img>
    );
  });

  const likeBtnClick = async () => {
    const res = await fetch(`likeCount?p_seq=${p_seq}`, {
      method: "GET",
    });
    const data = await res.json();
    setPInfo({ ...pInfo, p_like: data });
  };

  const imageChange = (e) => {
    const mainImg = pInfo.p_main_image;
    console.log(mainImg);
  };

  const cartIn = async () => {
    const res = await fetch(`cartIn?p_seq=${p_seq}&u_id=${loginUser.u_id}`, {
      method: "GET",
    });
    if (loginUser.u_id) {
      // 로그인 했을경우 db에 장바구니정보 담기
      // const data = await res.json();
    } else {
      // 로그인 안했을때 스토어에 담기
    }
  };

  return (
    <>
      <div className="prod_detail_top">
        <div className="prod_main_image">
          <img src={imagePath} alt="메인이미지" width="600px" height="400px" />
        </div>
        <div className="prod_desc">
          <div className="prod_detail_desc_div">
            <label>상품명 : </label>
            <span>{pInfo.p_name}</span>
          </div>
          <div className="prod_detail_desc_div">
            <label>상품가격 : </label>
            <span>{pInfo.p_price}</span>
          </div>
          <div className="prod_detail_desc_div">
            <label>상품설명 : </label>
            <span>{pInfo.p_text}</span>
          </div>
          <div className="prod_detail_desc_div">
            <label>찜개수 : </label>
            <span>{pInfo.p_like}</span>
          </div>
          <div className="prod_detail_btn_div">
            <button className="buy_btn">구매하기</button>
            <button onClick={likeBtnClick} type="none" className="like_btn">
              &#x1f49b;
            </button>
            <button className="inToCart_btn" onClick={cartIn}>
              장바구니 담기
            </button>
          </div>
        </div>
      </div>
      <div className="prod_subIamge">
        <div>{subImageList}</div>
      </div>
    </>
  );
};
export default ProductDetail;
