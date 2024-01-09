const initialState = {
  User: {
    u_id: "",
    u_password: "",
    u_name: "",
    u_nickname: "",
    u_phone: "",
    u_point: 0,
  },
};

const userChecker = (state = initialState, action) => {
  switch (action.type) {
    case "LOGIN":
      return {
        ...state,
        User: {
          ...state.User,
          u_id: action.payload.u_id,
          u_password: action.payload.u_password,
          u_name: action.payload.u_name,
          u_nickname: action.payload.u_nickname,
          u_phone: action.payload.u_phone,
          u_point: action.payload.u_point,
        },
      };
    case "LOGOUT":
      return {
        ...state,
        User: {
          ...state.User,
          u_id: "",
          u_password: "",
          u_name: "",
          u_nickname: "",
          u_phone: "",
          u_point: 0,
        },
      };
    default:
      return state;
  }
};
export default userChecker;
