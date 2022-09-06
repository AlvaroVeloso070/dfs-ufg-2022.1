import React from "react";
import './App.css';

import {BrowserRouter, Routes, Route} from 'react-router-dom';
import LoginPage from "./pages/LoginPage/LoginPage";
import RegisterPage from "./pages/RegisterPage/RegisterPage";


const App = () => {
  return(
    // <LoginPage/>
    // <RegisterPage/>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginPage/>}></Route>
        <Route path="/register" element = {<RegisterPage/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;