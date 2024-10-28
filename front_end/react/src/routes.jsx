import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./website/pages/Home/Home";
import Cadastrar from "./website/pages/Cadastro/Cadastro";
import Login from "./website/pages/Login/Login"; 

function Rotas() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/cadastro" element={<Cadastrar />} />
                    <Route path="/login" element={<Login />} /> 
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default Rotas;
