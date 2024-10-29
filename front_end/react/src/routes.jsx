import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./website/pages/Home/Home";
import Cadastrar from "./website/pages/Cadastro/Cadastro.jsx";
import Products from "./website/pages/Products/Products.jsx"

function Rotas() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/cadastro" element={<Cadastrar />} />
                    <Route path="/produtos" element={<Products />} />
                </Routes>
            </BrowserRouter>
        </>
    )
}
export default Rotas;