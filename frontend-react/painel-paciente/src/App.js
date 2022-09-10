import React, { useState } from "react";
import './App.css';

import {BrowserRouter, Routes, Route} from 'react-router-dom';
import LoginPage from "./pages/LoginPage/LoginPage";
import RegisterPage from "./pages/RegisterPage/RegisterPage";
import { HomePage } from "./pages/HomePage/HomePage";

const App = () => {
  return(
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginPage/>}/>
        <Route path="/register" element = {<RegisterPage/>}/>
        <Route path="/home" element = {<HomePage/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
