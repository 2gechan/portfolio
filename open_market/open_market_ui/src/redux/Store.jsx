import { configureStore } from "@reduxjs/toolkit";
import { UserSlice } from "./UserSlice";
import { persistStore, persistReducer } from "redux-persist";
// import storage from "redux-persist/lib/storage"; // 로컬 스토리지
import sessionStorage from "redux-persist/lib/storage/session";

const persistConfig = {
  key: "root",
  storage: sessionStorage,
  // storage: storage,
};

const persistedReducer = persistReducer(persistConfig, UserSlice.reducer);

export const store = configureStore({
  reducer: {
    user: persistedReducer,
  },
});

export const persistor = persistStore(store);
