import { combineReducers } from "redux";
import userReducer from "./UserReducer";
import cartReducer from "./CartReducer";

const rootReducer = combineReducers({
  userReducer,
  cartReducer,
});

export default rootReducer;
