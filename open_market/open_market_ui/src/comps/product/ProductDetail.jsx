import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";

const ProductDetail = () => {
  const { p_seq } = useParams();
  const [pInfo, setPInfo] = useState({});
  const [images, setImages] = useState([]);

  useEffect(() => {
    const p_infoRetv = async () => {
      const res = await fetch(`detail?p_seq=${p_seq}`, {
        method: "GET",
      });
      // const data = res.json();
      // console.log(data);
    };
    const subImagesListRetv = async () => {
      const res = await fetch(`detailImage?p_seq=${p_seq}`, {
        method: "GET",
      });
      // const data = res.json();
      // console.log(data);
    };
    p_infoRetv();
    subImagesListRetv();
  }, []);

  return <h1>상품 seq : {p_seq} 디테일 페이지</h1>;
};
export default ProductDetail;
