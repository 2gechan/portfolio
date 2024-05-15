import { combineReducers } from "redux";
import userReducer from "./UserReducer";
import cartReducer from "./CartReducer";
// import { UserSlice } from "./UserSlice";
// import { CartSlice } from "./CartSlice";

const rootReducer = combineReducers({
  userReducer,
  cartReducer,
  // user: UserSlice.reducer,
  // cart: CartSlice.reducer,
});

export default rootReducer;
