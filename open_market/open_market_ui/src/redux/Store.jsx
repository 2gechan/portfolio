import { configureStore } from "@reduxjs/toolkit";
import { UserSlice } from "./UserSlice";
import { persistStore, persistReducer } from "redux-persist";
// import storage from "redux-persist/lib/storage"; // 로컬 스토리지
import sessionStorage from "redux-persist/lib/storage/session";
import { CartSlice } from "./CartSlice";
// import rootReducer from "./RootReducer";

const persistConfig = {
  key: "root",
  storage: sessionStorage,
  // storage: storage,
};

// const persistedReducer = persistReducer(persistConfig, rootReducer);
const persistedReducer = persistReducer(persistConfig, UserSlice.reducer);
const cartReducer = persistReducer(persistConfig, CartSlice.reducer);

export const store = configureStore({
  reducer:
    // persistedReducer,
    {
      user: persistedReducer,
      cart: cartReducer,
    },
});

export const persistor = persistStore(store);
