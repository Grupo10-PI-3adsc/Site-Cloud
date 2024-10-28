import React, { useState } from 'react';
import Cadastrar from '../Cadastro/Cadastro.jsx';
import { Link, useNavigate } from "react-router-dom";

function Login() {
    const navigate = useNavigate();

    const handleRegisterClick = () => {
        navigate("/cadastro");
    };

    // Ajuste para sumir a label do input quando o campo estiver preenchido
    const [showEmailLabel, setShowEmailLabel] = useState(true);
    const [showPasswordLabel, setShowPasswordLabel] = useState(true);
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");

    return (
        <div className="auth-page">
            <div className="auth-container">
                <div className="auth-contents">
                    <div className="auth-titles">
                        <h1>Entre na sua conta<a>!</a></h1>
                        <p>Não tem conta? <a href="#" onClick={handleRegisterClick}>Cadastre-se!</a></p>
                    </div>
                    <div className="auth-inputs">
                        <div className="input-container">
                            {showEmailLabel && <label htmlFor="email">E-mail</label>}
                            <input 
                                type="text" 
                                id="email" 
                                value={email} 
                                onChange={(e) => setEmail(e.target.value)} 
                                onFocus={() => setShowEmailLabel(false)} 
                                onBlur={() => setShowEmailLabel(!email)} 
                            />
                        </div>
                        <div className="input-container">
                            {showPasswordLabel && <label htmlFor="senha">Senha</label>}
                            <input 
                                type="password" 
                                id="senha" 
                                value={senha} 
                                onChange={(e) => setSenha(e.target.value)} 
                                onFocus={() => setShowPasswordLabel(false)} 
                                onBlur={() => setShowPasswordLabel(!senha)} 
                            />
                        </div>
                    </div>
                    <button className="auth-btn">Prosseguir</button>
                </div>
            </div>
        </div>
    );
}

export default Login;
