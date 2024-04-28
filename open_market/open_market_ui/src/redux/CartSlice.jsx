import { createSlice } from "@reduxjs/toolkit";

const stateReset = {
  cart: {
    cart_p_name: "",
    cart_p_price: "",
    cart_p_image: "",
  },
};

export const CartSlice = createSlice({
  name: "cart",
  initialState: {
    stateReset,
  },

  reducers: {
    loginUserCart: (state, action) => {
      state.cart = { ...state.cart, ...action.payload };
    },
    logoutUserCart: (state, action) => {
      state.cart = stateReset.cart;
    },
  },
});

export const { loginUserCart, logoutUserCart } = CartSlice.actions;
export default CartSlice.reducer;
