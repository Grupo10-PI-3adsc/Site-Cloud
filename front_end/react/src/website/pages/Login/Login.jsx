import React, { useState } from 'react';
import Cadastrar from '../Cadastro/Cadastro.jsx';
import { Link, useNavigate } from "react-router-dom";
import Header from "../../components/Header";

function Login() {
    const navigate = useNavigate();

    const handleRegisterClick = (path) => {
        navigate(path);
    };

    // Ajuste para sumir a label do input quando o campo estiver preenchido
    const [showEmailLabel, setShowEmailLabel] = useState(true);
    const [showPasswordLabel, setShowPasswordLabel] = useState(true);
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");


    const handleSubmit = async (e) => {
        e.preventDefault();

        const data = {
            email,
            senha
        };

        try {
            const response = await fetch(`${apiUrl}/auth/login`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                alert("Login realizado com sucesso!");
                navigate("/");
            } else {
                alert("Falha no login");
            }
        } catch (error) {
            console.error("Erro ao enviar dados:", error);
        }
    }


    return (
        <>
        <Header/>
        <div className="auth-page">
            <div className="auth-container">
                <div className="auth-contents">
                    <div className="auth-titles">
                        <h1>Entre na sua conta<a>!</a></h1>
                        <p>Não tem conta? <a href="#" onClick={() => handleRegisterClick("/cadastro")}>Cadastre-se!</a></p>
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
                             <div className="auth-titles">
                        <p>Esqueceu sua senha? <a href="#" onClick={() => handleRegisterClick("/recuperar-senha")}>Recuperar Senha</a></p>
                    </div>
                        </div>
                    </div>
                    <button className="auth-btn" type='submit'>Prosseguir</button>
                </div>
            </div>
        </div>
        </>
    );
}

export default Login;
