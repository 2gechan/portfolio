import React from "react";
import ReactDOM from "react-dom/client";
import "./css/index.css";
import reportWebVitals from "./reportWebVitals";
import MainRouter from "./router/MainRouter";
import { Provider } from "react-redux";
import { store, persistor } from "./redux/Store";
import { PersistGate } from "redux-persist/integration/react";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <PersistGate persistor={persistor}>
        <MainRouter />
      </PersistGate>
    </Provider>
  </React.StrictMode>
);
reportWebVitals();
