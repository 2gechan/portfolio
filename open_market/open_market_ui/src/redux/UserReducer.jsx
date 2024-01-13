import { createSlice } from "@reduxjs/toolkit";

export const user = createSlice({
  name: "user",

  initialState: {
    user: {
      u_id: "",
      u_password: "",
      u_name: "",
      u_nickname: "",
      u_phone: "",
      u_point: 0,
    },
  },

  reducers: {
    login: (state, action) => {
      state.user = { ...state.user, ...action.payload };
    },
    logout: (state) => {
      state.user = {
        u_id: "",
        u_password: "",
        u_name: "",
        u_nickname: "",
        u_phone: "",
        u_point: 0,
      };
    },
  },
});

export const { login, logout } = user.actions;
export default user.reducer;
