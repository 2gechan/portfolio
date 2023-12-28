import { Outlet } from "react-router";
import Header from "./comps/Header";

import "./css/App.css";
import "./css/Header.css";

function App() {
  return (
    <div className="App">
      <header className="main_header">
        <Header />
      </header>
      <div className="main_body">
        <Outlet />
      </div>
    </div>
  );
}

export default App;
