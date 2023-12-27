import { useEffect, useState } from "react";
const ShopMain = () => {
  const [message, setMessage] = useState(null);
  useEffect(() => {
    const fetchData = async () => {
      const res = await fetch("/main", {
        method: "GET",
      });
      const result = await res.text();
      console.log(result);
      setMessage(result);
    };
    fetchData();
  }, []);
  return <h1>{message}</h1>;
};

export default ShopMain;
