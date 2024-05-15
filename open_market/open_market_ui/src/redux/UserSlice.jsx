import { createSlice } from "@reduxjs/toolkit";

const stateReset = {
  user: {
    u_id: "",
    u_password: "",
    u_name: "",
    u_nickname: "",
    u_phone: "",
    u_point: 0,
  },
};
export const UserSlice = createSlice({
  name: "user",
  initialState: {
    stateReset,
  },

  reducers: {
    login: (state, action) => {
      state.user = { ...state.user, ...action.payload };
    },
    logout: (state) => {
      state.user = stateReset.user;
    },
  },
});

export const { login, logout } = UserSlice.actions;
export default UserSlice.reducer;
