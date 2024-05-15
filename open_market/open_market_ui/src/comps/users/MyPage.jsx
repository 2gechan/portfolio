import { useSelector } from "react-redux";

const MyPage = () => {
  const loginUser = useSelector((state) => state.user.user) || {};
  return (
    <>
      <h1>MyPage</h1>
      <h2>{loginUser.u_id}</h2>
      <h2>{loginUser.u_password}</h2>
      <h2>{loginUser.u_phone}</h2>
      <h2>{loginUser.u_point}</h2>
    </>
  );
};

export default MyPage;
